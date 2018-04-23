package farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Init {
    private Scanner scanner;
    private MenuBarn menuBarn;
    private static String farmerName;
    private static List<Barn> barns;

    public Init() {
        scanner = new Scanner(System.in);
        menuBarn = new MenuBarn();
        barns = new ArrayList<>();
    }

    public void initSystem() {
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

    public void checkFarmer(String farmerName) {
        System.out.println(farmerName);
        String path = "C:\\Farm\\" + farmerName;
        System.out.println(path);
        if (farmerName.length() == 0) {
            initSystem();

        } else if(Utils.isExist(path)) {
            System.out.println("Welcome " + farmerName);
            String[] files = Utils.showFiles();
            for (String file : files) {
                System.out.println(file);
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
}
