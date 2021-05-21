package service;

import java.io.IOException;

public class ValidateInput {
    public static boolean validateName(String name)
    {
        return name.matches("[A-Z][a-zA-Z]*");
    }

    public static boolean validateSurname(String surname)
    {
        return surname.matches("[A-Z][a-zA-Z]*");
    }

    public static boolean validateUsername(String username) throws IOException {
        boolean isExist = false;
            for (String data : FileService.read("src\\database.txt")) {
                if (username.equals(data.split(",")[1])) {
                    isExist = true;
                    break;
                }
            }
        if (isExist) System.out.println("This username is already exists.");
        return !isExist && username.length() > 10;
    }

    public static boolean validateEmail (String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    public static boolean validatePassword(String password) {
        int countOfDigits = 0;
        int countOfUpperCase = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= '0' && c <= '9') ++countOfDigits;
            if (c >= 'A' && c <= 'Z') ++countOfUpperCase;
        }
        return (password.length() > 8) && (countOfUpperCase >= 2) && (countOfDigits >= 3);
    }

}
