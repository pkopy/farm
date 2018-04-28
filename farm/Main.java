package farm;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        MenuBarn menuBarn = new MenuBarn();
        Init init = new Init();
//        Barn barn = new Barn();
        try {
            init.initSystem();
        } catch (IOException e) {
            e.printStackTrace();
        }
//Test
        Animal animal = new Animal("Cow",3,true);
        Animal animal1 = new Animal("Cow",2,false);
//        barn.addAnimal(animal);
//        barn.addAnimal(animal1);
//        System.out.println(barn.getAnimals());
//        System.out.println(barn.getBarns());
//        System.out.println(barn.getIdBarn());

//        String test = "";
//        File file = new File("C:\\Bootcamp\\babcia.txt");
//        try {
//            test = Utils.readFileContent(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(test);


    }
}
