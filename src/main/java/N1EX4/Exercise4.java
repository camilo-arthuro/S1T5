package N1EX4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Exercise4 {
    public static void runProgram(){

        //Variables
        Scanner input = new Scanner(System.in);
        String relativePath = "";

        //Introducing the route
        System.out.println("Enter the route: ");
        relativePath = input.next();

        //Show the content
        showContent(relativePath);
    }

    public static void showContent(String relativePath){
        String info = "";

        try (FileReader fr = new FileReader(relativePath); BufferedReader br = new BufferedReader(fr)){
            info = br.readLine();
            System.out.println(info);
        } catch (IOException e){
            System.out.println("File not found");
        }
    }

}
