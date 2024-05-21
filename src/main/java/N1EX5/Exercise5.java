package N1EX5;

import java.io.*;
import java.util.Scanner;

public class Exercise5 {
    public static void runProgram(){
        //Variables
        Scanner input = new Scanner(System.in);
        String relativePath = "";
        Person[] personList = new Person[5];

        //Adding the people to the list
        personList[0] = new Person("Adrian Kakuja", 25);
        personList[1] = new Person("Camilo Delgado", 29);
        personList[2] = new Person("Carlos Flores", 32);
        personList[3] = new Person("Barbara Flores", 24);
        personList[4] = new Person("Ivan Fuentes", 30);

        //Defining the path
        System.out.println("Enter the path of the file: ");
        relativePath = input.nextLine();

        //Serialize object
        serObject(personList, relativePath);

        //Deserialize Object
        desserObject(relativePath);

    }

    public static void serObject(Person[] personList, String relativePath){
        try (ObjectOutputStream outPut = new ObjectOutputStream(
                new FileOutputStream(relativePath))){
            outPut.writeObject(personList);
        } catch (IOException e){
            System.out.println("File not found");
        }
    }

    public static void desserObject(String relativePath){
        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(relativePath))){
            Person[] desserPerson = (Person[]) input.readObject();

            for (Person person :desserPerson){
                System.out.println(person.toString());
            }
        } catch (IOException | ClassNotFoundException e){
            System.out.println("File not found");
        }
    }

}
