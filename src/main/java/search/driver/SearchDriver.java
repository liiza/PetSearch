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

    private String apiKey;


    public SearchDriver(String apiKey){
        this.apiKey = apiKey;
    }

    @PostConstruct
    public void fetchResults(){
        String urlGetObjects = baseUrl + method + format + key + apiKey + location + count;
        System.out.println("Url where trying to fetch the objects " + urlGetObjects);
        PetList pets = getForObject(urlGetObjects, PetList.class);
        String output = getForObject(urlGetObjects, String.class);
        System.out.println(output);
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
    private static Pet mapToIndex(PetEntity pet){
        return new Pet (pet.getName().getValue(),
                pet.getAge().getValue(),
                pet.getAnimal().getValue(),
                null,
                pet.getSex().getValue(),
                pet.getShelterId().getValue(),
                pet.getSize().getValue(),
                null);

    }

}
