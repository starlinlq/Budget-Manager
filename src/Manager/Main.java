package Manager;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UserCollection collection = new UserCollection();
    static String path = "";
    
    public static void readObj(){
       try{
           FileInputStream file = new FileInputStream(path);
           ObjectInputStream in = new ObjectInputStream(file);
           collection = (UserCollection) in.readObject();
       } catch (IOException | ClassNotFoundException ex){
           System.out.println(ex.getMessage());
       }
    }

    public static void writeObj(){
        try{
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(collection);
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        displayMenu();

      while(true) {
          try {
              int opt = Integer.parseInt(scanner.nextLine());
              switch (opt) {
                  case 1: {};
                  case 2: {};
                  case 3: {};
                  case 4: {};
                  case 5: {};
                  case 0: {
                      break;
                  }
                  default:{
                      System.out.println("Wrong option, try again");
                  }
              }

          } catch(NumberFormatException ex){
              System.out.println("Invalid number");
          }
      }

    }

    public static void displayMenu(){

        System.out.println("Choose your action: \n" +
                           "1) Add income \n" +
                           "2) Add Purchase \n" +
                           "3) Show list of purchases \n" +
                           "4) Balance \n" +
                           "5) Save \n" +
                           "0) Exit ");

    }

}
