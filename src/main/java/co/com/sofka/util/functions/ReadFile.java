package co.com.sofka.util.functions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

    public static void main(String[] args) throws IOException {

        final String RUTA_ABS = "D:\\Sofka U\\QA\\Automatizacion\\GitLab Ivan\\qa-ciclo-1-2022\\ServicesExample\\src\\test\\resources\\files\\login\\login.json";
        final String USER_DIR = System.getProperty("user.dir");
        System.out.println("WORKING DIR: "+USER_DIR);
        final String RUTA_REL = USER_DIR +"\\src\\test\\resources\\files\\login\\login.json";

        readFileFromPath(RUTA_REL);

    }

    public static String readFileFromPath(String filePath) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        System.out.println("El contenido del JSON es: "+content);
        return content;
    }


}
