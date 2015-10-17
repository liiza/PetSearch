package search.repository;


import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SearchService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> search(String term) {
        MultiMatchQueryBuilder query = QueryBuilders.multiMatchQuery(term)
                .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                .field("animal")
                .field("name")
                .field("size")
                .field("sex")
                .field("age")
                .field("description")
                .field("breed")
                .operator(MatchQueryBuilder.Operator.AND);
        Iterable<Pet> pets = petRepository.search(query);
        return toList(pets);
    }

    private List<Pet> toList(Iterable<Pet> pets) {
        List<Pet> petList = new ArrayList<Pet>();
        for(Pet pet: pets) {
            petList.add(pet);
        }
        return petList;

    }
}
