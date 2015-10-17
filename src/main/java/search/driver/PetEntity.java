package search.driver;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import search.repository.Pet;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetEntity {

    @JsonProperty
    private EntityObject id;

    @JsonProperty("animal")
    private EntityObject animal;

    @JsonProperty
    private EntityObject  name;

    @JsonProperty
    private BreedList breeds;

    @JsonProperty
    private EntityObject size;

    @JsonProperty
    private EntityObject sex;

    @JsonProperty
    private EntityObject location;

    @JsonProperty
    private EntityObject shelterId;

    @JsonProperty
    private EntityObject age;

    @JsonProperty
    private EntityObject description;

    public EntityObject getAnimal() {
        return animal;
    }

    public void setAnimal(EntityObject animal) {
        this.animal = animal;
    }

    public EntityObject getName() {
        return name;
    }

    public void setName(EntityObject name) {
        this.name = name;
    }



    public EntityObject getSize() {
        return size;
    }

    public void setSize(EntityObject size) {
        this.size = size;
    }

    public EntityObject getSex() {
        return sex;
    }

    public void setSex(EntityObject sex) {
        this.sex = sex;
    }

    public EntityObject getLocation() {
        return location;
    }

    public void setLocation(EntityObject location) {
        this.location = location;
    }

    public EntityObject getShelterId() {
        return shelterId;
    }

    public void setShelterId(EntityObject shelterId) {
        this.shelterId = shelterId;
    }

    public EntityObject getAge() {
        return age;
    }

    public void setAge(EntityObject age) {
        this.age = age;
    }

    public EntityObject getDescription() {
        return description;
    }

    public void setDescription(EntityObject description) {
        this.description = description;
    }

    public EntityObject getId() {
        return id;
    }

    public void setId(EntityObject id) {
        this.id = id;
    }

    public BreedList getBreeds() {
        return breeds;
    }

    public void setBreeds(BreedList breeds) {
        this.breeds = breeds;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class EntityObject {

        @JsonProperty ("$t")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

    public static class BreedList {

        @JsonDeserialize(using = BreedDeserializer.class)
        private List<Breed> breed;

        public List<Breed> getBreed() {
            return breed;
        }
    }

    public static class Breed {

        @JsonProperty("$t")
        private String breed;

        public String getBreed() {
            return breed;
        }

        public void setBreed(String breed) {
            this.breed = breed;
        }

    }




}
