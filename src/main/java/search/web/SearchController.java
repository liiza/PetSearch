package search.web;


import org.elasticsearch.index.search.MultiMatchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.web.bind.annotation.*;
import search.repository.Pet;
import search.repository.PetRepository;
import search.repository.SearchService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SearchController {

    @Autowired
    PetRepository repository;

    @Resource
    SearchService searchService;


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody List<Pet> searchByName(@RequestBody String query){
        List<Pet> pets = searchService.search(query);
        return pets;
    }
}
