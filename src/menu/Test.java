package menu;

import service.MD5;

import java.io.IOException;
import java.security.spec.ECField;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        boolean isMenuActive = true;
        Scanner s = new Scanner(System.in);

        while (isMenuActive) {
            System.out.println("1. Registration");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int command = s.nextInt();

            switch (command) {
                case 1:
                    try {
                        service.Registration.register();
                    } catch (Exception e) {
                        System.out.println("Registration failed!");
                    }
                    break;
                case 2:
                    try {
                        service.Login.login();
                    } catch (Exception e) {
                        System.out.println("Login failed!");
                    }
                    break;
                case 3:
                    isMenuActive = false;
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid command number.");

            }
        }
    }

}
