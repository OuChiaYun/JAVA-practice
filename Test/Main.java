// package Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s = args[0];
        readFile(s);
    }

    public static void readFile(String str) {

        try {
            System.out.println(str);

            File file = new File(str);
            Scanner scanner = new Scanner(file);
            List<String[]> list = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String scnStr = scanner.nextLine();
                String[] strSplStrings = scnStr.split(",");
                // System.out.println(strSplStrings[0]);
                list.add(strSplStrings);
            }
            System.out.println("===========================");
            for (String[] s : list) {
                for (String ss : s) {
                    System.out.println(ss);
                }

            }
        } catch (Exception e) {

        }

    }

}
