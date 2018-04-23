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

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", animalId=" + animalId +
                ", age=" + age +
                ", isGraft=" + isGraft +
                ", birthday=" + birthday +
                '}';
    }
}
