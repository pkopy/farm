package farm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAnimal {

    private Scanner scanner;
    private List<Barn> barns;
    private List<Barn> animals;
    private int numberOfBarn;

    public MenuAnimal() {
        scanner = new Scanner(System.in);
        animals = new ArrayList<>();
        barns = new ArrayList<>();
    }

    public void start(int numberOfBarn) throws IOException{
        this.numberOfBarn = numberOfBarn;

        String answer;

        do{
            System.out.println("\nWybierz opcję: ");
            printChoseList();
            checkAnswer(answer = scanner.nextLine());

        }while(!answer.equalsIgnoreCase("exit"));
    }

    public void checkAnswer(String answer) throws IOException{
        switch (answer) {
            case "1":{
                Animal animal = new Animal();
                System.out.println("Add species");
                animal.setSpecies(scanner.nextLine());
                System.out.println("Add age");
                animal.setAge(Integer.valueOf(scanner.nextLine()));
                System.out.println("Is animal graft? Y/N");
                animal.setGraft(yesNo());
                barns = Init.getBarns();
                barns.get(numberOfBarn).addAnimal(animal);
                String nameOfFile = "C:\\Farm\\"+ Init.getFarmerName() +"\\" + "barn" + barns.get(numberOfBarn).getIdBarn() + ".txt";
                Utils.saveToFile(nameOfFile, barns.get(numberOfBarn).toString());
                break;
            }
            case "2": {
                barns = Init.getBarns();
                System.out.println("Write Id ");
                Barn barn = barns.get(numberOfBarn);
                System.out.println(barn.getAnimals().get(Integer.valueOf(scanner.nextLine())).printAnimal());

                break;
            }
            case "3": {
                System.out.println(Init.getBarns().get(numberOfBarn).printAllAnimal());
            }
        }
    }

    private boolean yesNo() {
        if(scanner.nextLine().equalsIgnoreCase("y")){
            return true;
        }

        return false;
    }

    private void printChoseList() {
        System.out.println();
        System.out.println("1 - add new animal");
        System.out.println("2 - print animal");
        System.out.println("3 - print all animals");
//        System.out.println("4 - zamiana typu binarnego na dziesiętny,");
//        System.out.println("5 - zamiana typu binarnego na ósemkowy");
//        System.out.println("6 - pierwiastek x z liczby y");

    }
}
