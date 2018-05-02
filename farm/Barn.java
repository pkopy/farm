package farm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Barn {
    private String name;
    private int idBarn;
    private List<Animal> animals;
    private String path;


    public Barn(String name) {

        animals = new ArrayList<>();
        idBarn = initOrSetIdBarn();
        path = "";
        this.name = name + idBarn;

    }

    public Barn() {
        this("Barn-");
    }


    public int initOrSetIdBarn() {
        if (Init.getBarns().size() != 0) {
            return idBarn = Init.getBarns().getLast().getIdBarn() + 1;

        } else {
            return idBarn = 1;
        }

    }

    public void findOldestOrYoungest(Comparator<Animal> comparator) {
        ArrayList<Animal> sotredAnimal = new ArrayList<>();
        animals.stream()
                .sorted(comparator)
                .limit(5)
                .forEach(sotredAnimal::add);
        System.out.println(printAllAnimal(sotredAnimal));
    }

    public void findGraftAnimals() {
        ArrayList<Animal> graftAnimals = new ArrayList<>();
        for(Animal animal : animals){
            if(animal.isGraft()) {
                graftAnimals.add(animal);
            }
        }
        System.out.println(printAllAnimal(graftAnimals));
    }


    public void addBarn(Barn barn) throws IOException {

        Init.getBarns().add(barn);
        String nameOfFile = "C:\\Farm\\" + Init.getFarmerName() + "\\" + "barn" + barn.getIdBarn() + ".txt";
        path = nameOfFile;
        Utils.createNewFile(nameOfFile);
        Utils.saveToFile(nameOfFile, barn.toString());

    }


    public void addAnimal(Animal animal) {
        animal.setAnimalId(animals.size());
        animals.add(animal);
    }

    public String printAllAnimal(List<Animal> animals) {
        StringBuilder animalsInBarn = new StringBuilder();

        for (Animal animal : animals) {
            animalsInBarn.append(animal.printAnimal());
            animalsInBarn.append("\n-------------------\n");
        }
        if(animals.size() == 0) {
            return "You don`t have any animals";
        }else {
            return animalsInBarn.toString();
        }

    }

    public String printAllAnimal(List<Animal> animals, int amount) {
        StringBuilder animalsInBarn = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            animalsInBarn.append(animals.get(i).printAnimal());
            animalsInBarn.append("\n-------------------\n");
        }
        return animalsInBarn.toString();
    }


    public int getIdBarn() {
        return idBarn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdBarn(int idBarn) {
        this.idBarn = idBarn;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return
                name + '/' + idBarn + '/' + animals;
    }
}
