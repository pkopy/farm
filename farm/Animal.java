package farm;

import java.time.LocalDateTime;

public class Animal {
    private String species;
    private int animalId;
    private int age;
    private boolean isGraft;
    private LocalDateTime birthday;

    public Animal(String species, int age, boolean isGraft) { //, int year, int month, int day
        this.species = species;
        this.age = age;
        this.isGraft = isGraft;
//        birthday = LocalDateTime.of(year, month, day, 0, 0);
    }

    public Animal(){

    }
//Add new commit


    public String getSpecies() {
        return species;
    }

    ////////////////////////

    public void setSpecies(String species) {
        this.species = species;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public void setGraft(boolean graft) {
        this.isGraft = graft;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String printAnimal() {
        return "Species: " + species + "\n" +
                "ID's animal: " + animalId + "\n" +
                "Age: " + age + "\n" +
                "Is graft?: " + isGraft;
    }

    @Override
    public String toString() {
        return species + ':' + animalId + ':' +  age + ':'  + isGraft;
    }
}