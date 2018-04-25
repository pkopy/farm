package farm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Barn {
    private String name;
    private int idBarn;
    private List<Animal> animals;
    private String path;


    public Barn() {
        this.name = name;
        animals = new ArrayList<>();
        if(Init.getBarns().size() !=0){
            idBarn = Init.getBarns().getLast().getIdBarn() + 1;

        }else {
            idBarn = 1;
        }
        path = "";

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

    public String printAllAnimal() {
        StringBuilder animalsInBarn = new StringBuilder();
        for (Animal animal : animals) {
            animalsInBarn.append(animal.printAnimal());
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
