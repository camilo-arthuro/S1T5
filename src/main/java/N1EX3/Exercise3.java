package N1EX3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Exercise3 {
    public static void runProgram(){
        //Variables
        Scanner input = new Scanner(System.in);
        String[] nameList;
        File[] fileList;
        File directoryReader;
        String pathRead = "";
        String pathWrite = "";
        String result = "";

        //Introducing the route
        System.out.println("Enter the route to read: ");
        pathRead = input.next();
        System.out.println("Enter the route to write: ");
        pathWrite = input.next();

        //Get the directory
        directoryReader = new File(pathRead);

        //List the files
        nameList = directoryReader.list();
        fileList = directoryReader.listFiles();

        //Show the files
        result = showList(nameList, fileList, pathRead);

        //Write the file.txt
        saveData(result, pathWrite);
    }

    public static String showList(String[] nameList, File[] fileList, String relativePath){
        File fileReader;
        String[] fileName;
        File[] fileDate;
        Date lastModification;
        String result = "";

        for (int i = 0; i < nameList.length; i++) {
            lastModification = new Date(fileList[i].lastModified());
            result += nameList[i] + " (D), last modification on " + lastModification + "\n";
            if (fileList[i] != null){
                fileReader = new File(relativePath + "/" + nameList[i]);
                fileName = fileReader.list();
                fileDate = fileReader.listFiles();
                for (int j = 0; j < fileName.length; j++){
                    lastModification = new Date(fileDate[j].lastModified());
                    result += " - " + fileName[j] + " (F), last modification on " + lastModification + "\n";
                }
            }
        }
        return result;
    }

    public static void saveData(String result, String pathWrite){
        try (FileWriter fr = new FileWriter(pathWrite);
             BufferedWriter bw = new BufferedWriter(fr)){
            bw.write(result);
        } catch (IOException e){
            System.out.println("File not found");
        }
    }

}
