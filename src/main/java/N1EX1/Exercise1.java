package N1EX1;

import java.io.File;
import java.util.Scanner;

public class Exercise1 {
    public static void runProgram(){
        //Variables
        Scanner input = new Scanner(System.in);
        String relativePath = "";

        //Introducing the route
        //If we Run the program with Intellij we can use the Path From Content Root
        // src/main/java/N1EX1/Directory
        System.out.println("Enter the route: ");
        relativePath = input.next();

        //Get the directory
        File directory = new File(relativePath);

        //List the files
        String[] list = directory.list();

        //Show the files
        for(String file : list){
            System.out.println(file);
        }
    }
}
