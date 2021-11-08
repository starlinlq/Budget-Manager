package Manager;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    //purchases.txt
    //User class
    //userCollection - is going to save all the users created -
    //      //     / - save in the file
    //hashmap key-values (name (key), price (value)) for the categories, and users
    //

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
