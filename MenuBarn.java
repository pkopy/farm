package farm;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuBarn {
    private Scanner scanner;
//    private Barn barn;

    public MenuBarn() {
        scanner = new Scanner(System.in);
//        barn = new Barn();
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

                break;
            }
            case "3": {
                List<Barn> barns = Init.getBarns();
                System.out.println("Your farm:");

                for (Barn barn : barns) {
                    System.out.println("Barn no: " + barn.getIdBarn());
                }


                break;
            }
        }
    }

    public Barn newBarn() {
        Barn barn = new Barn();
        return barn;
    }






    private void printChoseList() {
        System.out.println();
        System.out.println("1 - create new barn");
        System.out.println("2 - choose barn");
        System.out.println("3 - print all barns,");
//        System.out.println("4 - zamiana typu binarnego na dziesiętny,");
//        System.out.println("5 - zamiana typu binarnego na ósemkowy");
//        System.out.println("6 - pierwiastek x z liczby y");

    }
}
