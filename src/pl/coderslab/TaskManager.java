package pl.coderslab;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    public static String[] selectAnOption() {

        String[] options = {"add", "remove", "list", "exit"};
        for (String option : options) {
            System.out.println(option);
        }

        return options;
    }

    public static void readFromFile(String fileName) {

        File file = new File("/home/dawid/Pobrane/Zasoby_do_projektu/05_attachment_Zasoby do projektu.pl/tasks.csv");
        Path dir = Paths.get(fileName);
        if (!Files.exists(dir)) {
            System.out.println("File not exist.");
            System.exit(0);
        }
        String[][] tab = null;
        List<String> strings = null;
        try {
            strings = Files.readAllLines(dir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tab = new String[strings.size()][strings.get(0).split(",").length];
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main (String[]args) {

        readFromFile("/home/dawid/Pobrane/Zasoby_do_projektu/05_attachment_Zasoby do projektu.pl/tasks.csv");
        System.out.println(ConsoleColors.BLUE);
        System.out.println("Please select an option: " + ConsoleColors.RESET);
        selectAnOption();
    }
}