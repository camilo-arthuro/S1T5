package N1EX2;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Exercise2 {
    public static void runProgram (){
        //Variables
        Scanner input = new Scanner(System.in);
        String[] nameList;
        File[] fileList;
        File directoryReader;
        String relativePath = "";

        //Introducing the route
        //If we Run the program with Intellij we can use the Path From Content Root
        // src/main/java/N1EX2/World
        System.out.println("Enter the route: ");
        relativePath = input.next();
        //relativePath = "src/main/java/N1EX2/World";

        //Get the directory
        directoryReader = new File(relativePath);

        //List the files
        nameList = directoryReader.list();
        fileList = directoryReader.listFiles();

        //Show the files
        showList(nameList, fileList, relativePath);
    }

    public static void showList(String[] nameList, File[] fileList, String relativePath){
        File fileReader;
        String[] fileName;
        File[] fileDate;
        Date lastModification;

        for (int i = 0; i < nameList.length; i++) {
            lastModification = new Date(fileList[i].lastModified());
            System.out.println(nameList[i] + " (D), last modification on " + lastModification);
            if (fileList[i] != null){
                fileReader = new File(relativePath + "/" + nameList[i]);
                fileName = fileReader.list();
                fileDate = fileReader.listFiles();
                for (int j = 0; j < fileName.length; j++){
                    lastModification = new Date(fileDate[j].lastModified());
                    System.out.println(" - " + fileName[j] + " (F), last modification on " + lastModification);
                }
            }
        }
    }

}
