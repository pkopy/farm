package farm;

import java.util.ArrayList;
import java.util.List;

public class Barn {
    private String name;
    private int idBarn;
    private List<Animal> animals;
    private List<Barn> barns;

    public Barn(String name) {
        this.name = name;
        barns = new ArrayList<>();
        animals = new ArrayList<>();
        idBarn = barns.size();
    }

    public void addBarn(Barn barn) {

        barns.add(barn);

    }

    public void addAnimal(Animal animal){
        animal.setAnimalId(animals.size());
        animals.add(animal);
    }

    public int getIdBarn() {
        return idBarn;
    }


    public List<Barn> getBarns() {
        return barns;
    }

    public void setBarns(List<Barn> barns) {
        this.barns = barns;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public String toString() {
        return "Barn{" +
                "name='" + name + '\'' +
                ", idBarn=" + idBarn +
                ", animals=" + animals +
                '}';
    }
}
