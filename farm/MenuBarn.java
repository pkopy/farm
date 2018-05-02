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
                if (barnId <= 0 || barnId > Init.getBarns().size()-1){
                    MenuBarn menuBarn = new MenuBarn();

                    System.out.println("No barn has been removed \n");
                    menuBarn.start();

                }else {
                    Barn barn = Init.getBarns().get(barnId - 1);
                    System.out.println(barn.getPath());
                    Init.delete(barnId - 1);

                    try {
                        Utils.deleteFileOrCatalog(barn.getPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }

            case "5": {
                if(Init.maxAnimals().getIdBarn() == -1){
                    System.out.println("You don't have any barns");
                }else{
                    System.out.println("Barn whit the most amount of animals is: Barn " + Init.maxAnimals().getIdBarn() + "\n");
                }
                break;
            }

        }
    }

    public void openBarn(int number) {
        System.out.println("Barn no " + number);
        try {
            menuAnimal.start(number - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printBarns() {

        int count = 1;
        barns = Init.getBarns();

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
