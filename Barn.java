package farm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Barn {
    private String name;
    private int idBarn;
    private List<Animal> animals;



    public Barn() {
        this.name = name;
        animals = new ArrayList<>();
        idBarn = Init.getBarns().size();
        System.out.println(idBarn);
        //
    }

    public static void addBarn(Barn barn) throws IOException{

        Init.getBarns().add(barn);

        String nameOfFile = "C:\\Farm\\"+ Init.getFarmerName() +"\\" + "barn" + barn.getIdBarn() + ".txt";
        System.out.println("Nazwa: " + nameOfFile);
        Utils.createNewFile(nameOfFile);
        Utils.saveToFile(nameOfFile, barn.animals.toString());

    }

    public void addAnimal(Animal animal){
        animal.setAnimalId(animals.size());
        animals.add(animal);
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

    @Override
    public String toString() {
        return "Barn{" +
                "name='" + name + '\'' +
                ", idBarn=" + idBarn +
                ", animals=" + animals +
                '}';
    }
}
