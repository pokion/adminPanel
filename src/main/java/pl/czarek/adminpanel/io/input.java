package pl.czarek.adminpanel.io;

import java.util.Scanner;

public class input {

    public static String question(String zapytanie) {
        System.out.println(zapytanie + "\n");

        Scanner scan = new Scanner(System.in);

        return scan.nextLine();
    }


}
