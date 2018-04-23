package farm;

import java.io.*;

public class Utils {
    private static File file;

    public static void createNewFile(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        file.createNewFile();

        System.out.println();
    }

    public static void createNewCatalog(String pathToCatalog) {
        file = new File(pathToCatalog);
        file.mkdir();
    }

    public static void deleteFileOrCatalog(String path) throws IOException{
        file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader fileInputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

        fileInputStream.close();
        fileInputStreamReader.close();

        file.delete();

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

        fileInputStream.close();
        fileInputStreamReader.close();

        return stringBuilder.toString();
    }

    public static String[] showFiles() {
        return file.list();
    }

    public static void saveToFile(String path, String word) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(word.getBytes());
        fileOutputStream.close();
    }


}
