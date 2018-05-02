package farm;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {



        Init init = new Init();
        try {
            init.initSystem();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
