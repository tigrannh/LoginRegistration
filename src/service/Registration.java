package service;

import model.User;

import java.io.IOException;
import java.util.Scanner;

public class Registration {
    public static void register() throws IOException {
        System.out.println("Registration");
        boolean correct = false;
        Scanner s = new Scanner(System.in);

        String fullName = null;
        while (!correct) {
            System.out.print("Input full name (format: name surname):   ");
            fullName = s.nextLine();
            String[] info = fullName.split(" ");
            if (ValidateInput.validateName(info[0]) && ValidateInput.validateSurname(info[1])) {
                correct = true;
            }
            else {
                System.out.println("Invalid full name, input again.");;
            }
        }


        correct = false;
        String username = null;
        while (!correct) {
            System.out.print("Input username:   ");
            username = s.nextLine();
            if (ValidateInput.validateUsername(username)) {
                correct = true;
            }
            else {
                System.out.println("Invalid username, input again.");
            }
        }

        correct = false;
        String email = null;
        while (!correct) {
            System.out.print("Input email:   ");
            email = s.nextLine();
            if (ValidateInput.validateEmail(email)) {
                correct = true;
            }
            else {
                System.out.println("Invalid email, input again.");
            }
        }

        correct = false;
        String password = null;
        while (!correct) {
            System.out.print("Input password:   ");
            password = s.nextLine();
            if (ValidateInput.validatePassword(password)) {
                correct = true;
            }
            else {
                System.out.println("Invalid password, input again.");
            }
        }

        FileService.write("src\\database.txt", new User(fullName, username, email, password));
        System.out.println("You have successfully registered.");

    }

}
