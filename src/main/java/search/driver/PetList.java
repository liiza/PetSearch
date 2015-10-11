package search.driver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true) //must be there all times most likely
public class PetList {


    @JsonProperty
    private PetFinder petfinder;

    public PetFinder getPetfinder() {
        return petfinder;
    }

    public void setPetfinder(PetFinder petfinder) {
        this.petfinder = petfinder;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class PetFinder {


        @JsonProperty
        private EntityObject lastOffset;

        @JsonProperty("pets")
        private PetObjectList pets;

        public PetObjectList getPets() {
            return pets;
        }

        public void setPets(PetObjectList pets) {
            this.pets = pets;
        }

        public EntityObject getLastOffset() {
            return lastOffset;
        }

        public void setLastOffset(EntityObject lastOffset) {
            this.lastOffset = lastOffset;
        }



        @JsonIgnoreProperties(ignoreUnknown = true)
        public class PetObjectList {

            @JsonProperty("pet")
            private List<PetEntity> pet;


            public List<PetEntity> getPet() {
                return pet;
            }

            public void setPet(List<PetEntity> pet) {
                this.pet = pet;
            }
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

}
