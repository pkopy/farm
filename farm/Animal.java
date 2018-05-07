package farm;

import java.time.LocalDateTime;

//Krzysiek: moja zmiana

public class Animal implements Comparable<Animal> {
    private String species;
    private int animalId;
    private int age;
    private boolean isVaccinate;
    private LocalDateTime birthday;

    //nowa metoda
    public void meetMe() {
        System.out.println("To ja!");
    }

    public Animal(String species, int age, boolean isVaccinate) { //, int year, int month, int day
        this.species = species;
        this.age = age;
        this.isVaccinate = isVaccinate;
//        birthday = LocalDateTime.of(year, month, day, 0, 0);
    }

    public Animal() {

    }
//Paweł: usunułem


    public void setSpecies(String species) {
        this.species = species;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public boolean isVaccinate() {
        return isVaccinate;
    }

    public void setVaccinate(boolean vaccinate) {
        this.isVaccinate = vaccinate;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String printAnimal() {
        String vaccinate = isVaccinate ? "YES" : "NO";
        return "Species: " + species + "\n" +
                "ID's animal: " + animalId + "\n" +
                "Age: " + age + "\n" +
                "Is vaccinated?: " + vaccinate;
    }

    @Override
    public String toString() {
        return species + ':' + animalId + ':' + age + ':' + isVaccinate;
    }

    @Override
    public int compareTo(Animal o) {
        return Integer.compare(age, o.getAge()) * -1;
    }

    public  int compareTo1(Animal o) {
        return Integer.compare(age, o.getAge());
    }
}
