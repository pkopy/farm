package farm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Init {
    private Scanner scanner;
    private MenuBarn menuBarn;
    private static String  farmerName;
    private static List<Barn> barns;

    Init() {
        scanner = new Scanner(System.in);
        menuBarn = new MenuBarn();
        barns = new ArrayList<>();
    }

    public void initSystem() throws IOException{
        System.out.println("Farm ver 1.0");
        if (Utils.isExist("C:\\Farm")) {
            System.out.println("What's Your name");
            String farmerName = scanner.nextLine();
            this.farmerName = farmerName;
            checkFarmer(farmerName);
//            Utils.createNewCatalog(farmerName);
        } else {
            Utils.createNewCatalog("C:\\Farm");
        }
    }

    private void checkFarmer(String farmerName) throws IOException{

        String path = "C:\\Farm\\" + farmerName;

        if (farmerName.length() == 0) {
            initSystem();

        } else if(Utils.isExist(path)) {
            System.out.println("Welcome " + farmerName);
            String[] files = Utils.showFiles();
            File fileToRead;
            for (String file : files) {
                fileToRead = new File(path + "\\" + file);
                String[] barnInStore = Utils.readFileContent(fileToRead).split("/");
                String[] animalInFile = barnInStore[2].split(",");
                Barn barn = new Barn();

                if(barnInStore.length > 1 && animalInFile.length > 1) {


                    for (String s : animalInFile) {
                        String[] animalInStore = s.split(":");

                        Animal animal  = new Animal();
                        animal.setSpecies(animalInStore[0].substring(1));
                        animal.setAnimalId(Integer.valueOf(animalInStore[1]));
                        animal.setAge(Integer.valueOf(animalInStore[2]));
                        animal.setGraft(Boolean.valueOf(animalInStore[3]));
                        barn.addAnimal(animal);
                    }
                    barn.setName(barnInStore[0]);
                    barn.setIdBarn(Integer.valueOf(barnInStore[1]));
                    barn.addBarn(barn);
                }else{
                    barn.setName(barnInStore[0]);
                    barn.setIdBarn(Integer.valueOf(barnInStore[1]));
                    barn.addBarn(barn);
                }
            }
            
            menuBarn.start();

        } else {
            System.out.println("Do You want create new farm? Y/N");
            String yesNo = scanner.nextLine();
            createNewFarm(path, yesNo);
        }

    }

    public void createNewFarm(String path, String yesNo) {
        if(yesNo.equalsIgnoreCase("y")) {
            Utils.createNewCatalog(path);
            menuBarn.start();
        }else {
            return;
        }

    }

    public static String getFarmerName() {
        return farmerName;
    }

    public static List<Barn> getBarns() {
        return barns;
    }

    public static void setBarns(List<Barn> barns) {
        Init.barns = barns;
    }

    public static void delete(int idOfBarn) {
        Init.barns.remove(idOfBarn);

    }
}
