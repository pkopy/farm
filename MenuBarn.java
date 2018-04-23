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

        do{
            System.out.println("Wybierz opcję: ");
            printChoseList();
            checkAnswer(answer = scanner.nextLine());

        }while(!answer.equalsIgnoreCase("exit"));
    }

    private void checkAnswer(String answer) {

        switch(answer) {
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
                barns = Init.getBarns();
                printBarns();
                int numberBarn = Integer.valueOf(scanner.nextLine());
                openBarn(numberBarn);


                break;


            }
            case "3": {
                barns = Init.getBarns();
                System.out.println("Your farm:");
                printBarns();
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

        for (Barn barn : barns) {
            System.out.println("Barn no: " + barn.getIdBarn());
        }


    }






    private void printChoseList() {
        System.out.println();
        System.out.println("1 - create new barn");
        System.out.println("2 - choose barn");
        System.out.println("3 - print all barns,");
        System.out.println("4 - delete barn");
//        System.out.println("5 - zamiana typu binarnego na ósemkowy");
//        System.out.println("6 - pierwiastek x z liczby y");

    }
}
