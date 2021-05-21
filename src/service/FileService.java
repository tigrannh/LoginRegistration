package service;

import model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService {

    public static List<String> read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }


    public static void write(String path, User user) throws IOException {
        StringBuilder data = new StringBuilder()
                .append(user.getName())
                .append(" ")
                .append(user.getSurname())
                .append(",")
                .append(user.getUsername())
                .append(",")
                .append(user.getEmail())
                .append(",")
                .append(user.getPassword())
                .append("\n");
        Files.write(Paths.get(path), data.toString().getBytes(), StandardOpenOption.APPEND);
    }
}