package main.java.com.modules;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileExample {

    File myFile = new File("D:\\QATraining\\Person.txt");


    public void readFile(File myFile) {

        try {
            List<String> lines = FileUtils.readLines(myFile, StandardCharsets.UTF_8);

            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File is not in valid format");
        }
    }
    public List<String> readFile(String fileName) {

        myFile = new File(fileName);
        List<String> lines=new ArrayList<>();
        try {
             lines = FileUtils.readLines(myFile, StandardCharsets.UTF_8);

            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File is not in valid format");
        }
        return lines;
    }
}
