package service;

import java.io.IOException;
import java.util.Scanner;

public class Login {
    public static void login() throws IOException {
        System.out.println("Login");

        Scanner s = new Scanner(System.in);

        System.out.print("Username:   ");
        String username = s.nextLine();

        System.out.print("Password:   ");
        String password = s.nextLine();

        boolean exists = false;
        for (String data : FileService.read("src\\database.txt")) {
            String[] info = data.split(",");
            if (username.equals(info[1]) && MD5.getMD5(password).equals(info[3]) ) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("You have successfully logged in.");
        }
        else {
            System.out.println("Invalid input data.");
        }
    }
}
