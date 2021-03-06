package farm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAnimal {

    private Scanner scanner;
    private Barn barn;

    public MenuAnimal() {
        scanner = new Scanner(System.in);
    }

    public void start(int numberOfBarn) throws IOException {
        if (numberOfBarn < 0 || numberOfBarn > Init.getBarns().size() - 1) {
            MenuBarn menuBarn = new MenuBarn();
            menuBarn.start();
        } else {
            barn = Init.getBarns().get(numberOfBarn);
            System.out.println("Barn no: " + barn.getIdBarn());
        }

        String answer;

        do {
            System.out.println("\nWybierz opcję: ");
            printChoseList();
            checkAnswer(answer = scanner.nextLine());

        } while (!answer.equalsIgnoreCase("exit"));
    }

    public void checkAnswer(String answer) throws IOException {
        switch (answer) {
            case "1": {
                Animal animal = new Animal();
                System.out.println("Add species");
                animal.setSpecies(scanner.nextLine().toUpperCase());
                System.out.println("Add age");
                animal.setAge(Integer.valueOf(scanner.nextLine()));
                System.out.println("Is animal vaccinate? Y/N");
                animal.setVaccinate(yesNo());
                barn.addAnimal(animal);
                String nameOfFile = "C:\\Farm\\" + Init.getFarmerName() + "\\" + "barn" + barn.getIdBarn() + ".txt";
                Utils.saveToFile(nameOfFile, barn.toString());
                break;
            }
            case "2": {
                System.out.println("Give Id`s animal ");
                int idAnimal = Integer.valueOf(scanner.nextLine());

                if (barn.getAnimals().size() > 0 && idAnimal <= barn.getAnimals().size() - 1) {
                    System.out.println(barn.getAnimals().get(idAnimal).printAnimal());
                } else{
                    System.out.println("You don`t have animal with id: " + idAnimal);
                }
                break;
            }
            case "3": {
                System.out.println(barn.printAllAnimal(barn.getAnimals()));
                break;
            }
            case "4": {

                barn.findOldestOrYoungest(Animal::compareTo);
                break;

            }
            case "5": {
                barn.findOldestOrYoungest(Animal::compareTo1);
                break;
            }
            case "6": {
                barn.findVaccinateAnimals();
                break;
            }
        }
    }

    private boolean yesNo() {
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    private void printChoseList() {
        System.out.println();
        System.out.println("1 - add new animal");
        System.out.println("2 - print animal");
        System.out.println("3 - print all animals");
        System.out.println("4 - find 5 the oldest animals");
        System.out.println("5 - find 5 the youngest animals");
        System.out.println("6 - find vaccinated animals");

    }
}
