package search.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import search.repository.Pet;
import search.repository.PetRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;


public class SearchDriver extends RestTemplate{


    @Autowired
    PetRepository repository;


    private static final String baseUrl = "http://api.petfinder.com/";

    private static final String method = "pet.find";

    private static final String format = "?format=json";

    private static final String key = "&key=";

    private static final String location = "&location=California";

    private static final String count = "&count=10";

    private static final String output = "&output=full";

    private static final String detailsBaseUrl = "https://www.petfinder.com";

    private static final String petDetails = "/petdetail/";

    private String apiKey;


    public SearchDriver(String apiKey){
        this.apiKey = apiKey;
    }

    @PostConstruct
    public void fetchResults(){
        String urlGetObjects = baseUrl + method + format + key + apiKey + location + count + output;
        System.out.println("Url where trying to fetch the objects " + urlGetObjects);
        String output = getForObject(urlGetObjects, String.class);
        System.out.println(output);
        PetList pets = getForObject(urlGetObjects, PetList.class);

        if (pets != null && pets.getPetfinder() != null && pets.getPetfinder().getPets().getPet() != null) {
            List<Pet> petsToIndex = pets.getPetfinder()
                    .getPets()
                    .getPet()
                    .stream()
                    .map(SearchDriver::mapToIndex)
                    .collect(Collectors.toList());
            repository.save(petsToIndex);
        }


    }
    private static Pet mapToIndex(PetEntity petRaw){
        Pet pet = new Pet();
        if  (petRaw.getName() != null){
            pet.setName(petRaw.getName().getValue());
        }
        if  (petRaw.getAge() != null){
            pet.setAge(petRaw.getAge().getValue());
        }
        if  (petRaw.getAnimal() != null){
            pet.setAnimal(petRaw.getAnimal().getValue());
        }
        if  (petRaw.getBreeds() != null && petRaw.getBreeds().getBreed().size() >0){
            pet.setBreed(toList(petRaw.getBreeds().getBreed()));
        }
        if  (petRaw.getSex() != null){
            pet.setSex(petRaw.getSex().getValue());
        }
        if  (petRaw.getShelterId() != null) {
            pet.setShelterId(petRaw.getShelterId().getValue());
        }
        if  (petRaw.getSize() != null) {
            pet.setSize(petRaw.getSize().getValue());
        }
        if (petRaw.getDescription() != null){
            pet.setDescription(petRaw.getDescription().getValue());
        }
        if (petRaw.getId() != null){
            pet.setUrl(buildUrlFromId(petRaw.getId().getValue()));
        }
        return pet;
    }

    private static String toList(List<PetEntity.Breed> breeds) {
        String breedList = "";
        for(PetEntity.Breed breed: breeds) {
            breedList += breed.getBreed() + " ";
        }
        return breedList;
    }

    private static String buildUrlFromId(String id) {
        return detailsBaseUrl + petDetails + id;
    }

}
