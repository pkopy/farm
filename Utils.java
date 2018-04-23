package farm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {
    private static File file;

    public static void createNewFile(String pathToFile) throws IOException {
        file = new File(pathToFile);
        System.out.println(file.createNewFile());
        System.out.println();
    }

    public static void createNewCatalog(String pathToCatalog) {
        file = new File(pathToCatalog);
        System.out.println(file.mkdir());
    }

    public static void deleteFileOrCatalog(String path) {
        file = new File(path);
        System.out.println(file.delete());
    }

    public static boolean isExist(String path) {
        file = new File(path);
        return file.exists();
    }

    public static String readFileContent(File file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader fileInputStreamReader = new InputStreamReader(fileInputStream, "UTF-8"); //polskie znaki

        int read = 0;

        while ((read = fileInputStreamReader.read()) != -1){
            stringBuilder.append((char)read);
        }

        return stringBuilder.toString();
    }

    public static String[] showFiles() {
        return file.list();
    }
}
