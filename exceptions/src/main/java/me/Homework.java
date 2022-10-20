package me;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Homework {
    public static void main(String[] arg) throws InterruptedException, FileNotFoundException {
        /*/////     CHECKED      /////*/
        System.out.printf("%n test FileNotFoundException(checked) - %n");
        String sep = File.separator;
        File file = new File(sep + "Hs" + sep + "nobody");
        Scanner scanner = new Scanner(file);

        /*/////     UNCHECKED      /////*/
        System.out.printf("%n test StackOverflowError(unchecked) - %n");
        while (testError()) {
            System.out.printf(" now working %n");
            Thread.sleep(2000);
        }
    }

    private static boolean testError() {
        return true;
    }
}
