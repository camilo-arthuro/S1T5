package N1EX5;

import N1EX5.Classes.Person;

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

        //Serialize object
        serObject(personList);

        //Deserialize Object
        desserObject();

    }

    public static void serObject(Person[] personList){
        try (ObjectOutputStream outPut = new ObjectOutputStream(
                new FileOutputStream("src/main/java/N1EX5/Files/file.ser"))){
            outPut.writeObject(personList);
        } catch (IOException e){
            System.out.println("File not found");
        }
    }

    public static void desserObject(){
        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("src/main/java/N1EX5/Files/file.ser"))){
            Person[] desserPerson = (Person[]) input.readObject();

            for (Person person :desserPerson){
                System.out.println(person.toString());
            }
        } catch (IOException | ClassNotFoundException e){
            System.out.println("File not found");
        }
    }
}
