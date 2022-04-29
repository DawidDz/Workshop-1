package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskManager {

    public static void readFromFile(String fileName) {

        File file = new File("/home/dawid/Pobrane/Zasoby_do_projektu/05_attachment_Zasoby do projektu.pl/tasks.csv");
        try (Scanner scan = new Scanner(file)) {

            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        }
    }

    public static void main (String[]args) {

        readFromFile("tasks.csv");
    }
}