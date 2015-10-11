package search.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import search.repository.Pet;
import search.repository.PetRepository;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    PetRepository repository;



    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody List<Pet> searchByName(@RequestBody String query){
        List<Pet> pets = repository.findByAnimalContaining(query);
        return pets;
    }
}
