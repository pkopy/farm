package farm;

import java.util.Scanner;

public class MenuBarn {
    private Scanner scanner;

    public MenuBarn() {
        scanner = new Scanner(System.in);
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

                break;
            }
            case "2": {

                break;
            }
        }
    }

    private void printChoseList() {
        System.out.println();
        System.out.println("1 - write ID barn");
        System.out.println("2 - print all barns,");
//        System.out.println("3 - zamiana typu dzisiętnego na binarny,");
//        System.out.println("4 - zamiana typu binarnego na dziesiętny,");
//        System.out.println("5 - zamiana typu binarnego na ósemkowy");
//        System.out.println("6 - pierwiastek x z liczby y");

    }
}
