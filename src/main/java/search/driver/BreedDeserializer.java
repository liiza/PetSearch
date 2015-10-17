package search.driver;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class BreedDeserializer extends OptionalArrayDeserializer<PetEntity.Breed> {
    protected BreedDeserializer () {
        super(PetEntity.Breed.class);
    }
}
