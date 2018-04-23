package farm;

import java.util.Scanner;

public class Init {
    private Scanner scanner;
    private MenuBarn menuBarn;

    public Init() {
        scanner = new Scanner(System.in);
        menuBarn = new MenuBarn();
    }

    public void initSystem() {
        System.out.println("Farm ver 1.0");
        if (Utils.isExist("C:\\Farm")) {
            System.out.println("What's Your name");
            String farmerName = scanner.nextLine();
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
            String[] files =Utils.showFiles();
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
}
