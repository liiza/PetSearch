package search.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import search.driver.PetEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "pets", type = "pet", shards = 1, replicas = 0, refreshInterval = "-1", indexStoreType = "memory")
public class Pet {

    private String id;

    private String animal;

    private String name;

    private String breed;

    private String size;

    private String sex;

    private String location;

    private String shelterId;

    private String age;

    public Pet (){
        // For Spring
    }

    public Pet(String name, String age, String animal, String breed, String sex, String shelterId, String size, String location) {
        this.name = name;
        this.age = age;
        this.animal = animal;
        this.breed = breed;
        this.sex = sex;
        this.shelterId = shelterId;
        this.size = size;
        this.location = location;
    }


    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShelterId() {
        return shelterId;
    }

    public void setShelterId(String shelterId) {
        this.shelterId = shelterId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
