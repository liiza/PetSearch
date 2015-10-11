package search.driver;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import search.repository.Pet;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetEntity {

    @JsonProperty("animal")
    private EntityObject animal;

    @JsonProperty
    private EntityObject  name;

    private EntityObject  breed;

    @JsonProperty
    private EntityObject  size;

    @JsonProperty
    private EntityObject  sex;

    @JsonProperty
    private EntityObject  location;

    @JsonProperty
    private EntityObject  shelterId;

    @JsonProperty
    private EntityObject age;

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

    public EntityObject getBreed() {
        return breed;
    }

    public void setBreed(EntityObject breed) {
        this.breed = breed;
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


}
