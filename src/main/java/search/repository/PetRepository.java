package search.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PetRepository extends ElasticsearchRepository<Pet, String> {

    List<Pet> findByAnimalContaining(String animal);

}
