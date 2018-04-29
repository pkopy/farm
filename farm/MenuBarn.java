package farm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuBarn {
    private Scanner scanner;
    private List<Barn> barns;
    private MenuAnimal menuAnimal;

    public MenuBarn() {
        scanner = new Scanner(System.in);
        barns = new ArrayList<>();
        menuAnimal = new MenuAnimal();
    }

    public void start() {

        String answer;


        do {
            System.out.println("Wybierz opcję: ");
            printChoseList();
            checkAnswer(answer = scanner.nextLine());

        } while (!answer.equalsIgnoreCase("exit"));
    }

    private void checkAnswer(String answer) {

        switch (answer) {
            case "1": {
                Barn barn = new Barn();
                try {
                    barn.addBarn(barn);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                barns = Init.getBarns();
                break;
            }
            case "2": {
                System.out.println("Choose barn:");
                barns = Init.getBarns();
                printBarns();
                int numberBarn = Integer.valueOf(scanner.nextLine());
                openBarn(numberBarn);
                break;
            }
            case "3": {
                barns = Init.getBarns();
                if (barns.size() > 0) {
                    System.out.println("Your farm:");
                    printBarns();
                } else {
                    System.out.println("You haven`t any barns");
                }
                break;
            }

            case "4": {
                System.out.println("Give id of barn");
                printBarns();
                int barnId = Integer.valueOf(scanner.nextLine());
                Barn barn = Init.getBarns().get(barnId);
                System.out.println(barn.getPath());
                Init.delete(barnId);
                try {
                    Utils.deleteFileOrCatalog(barn.getPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "5": {
                System.out.println("Farm whit the most amount of animals: " + Init.maxAnimals() + "\n");
                break;
            }

        }
    }

    public void openBarn(int number) {
        System.out.println("Barn no " + number);
        try {
            menuAnimal.start(number);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printBarns() {

        int count = 0;

        for (Barn barn : barns) {
            System.out.println(count + ". - Barn no: " + barn.getIdBarn());
            count++;
        }


    }


    private void printChoseList() {
        System.out.println();
        System.out.println("1 - create new barn");
        System.out.println("2 - choose barn");
        System.out.println("3 - print all barns,");
        System.out.println("4 - delete barn");
        System.out.println("5 - find the farm with the most animals");
//        System.out.println("6 - pierwiastek x z liczby y");

    }
}
