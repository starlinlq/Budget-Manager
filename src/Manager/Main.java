package Manager;

import java.io.IOException;
import java.util.Arrays;
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

<<<<<<< HEAD
        while(true) {
            try {
                int opt = Integer.parseInt(scanner.nextLine());

                switch (opt){
                    case 1: {
                        char c = '\n';
                        int length = 1;
                        char[] chars = new char[length];
                        Arrays.fill(chars, c);
                        System.out.print(String.valueOf(chars));
                        Runtime.getRuntime().exec("clear");
                        System.out.println("just seeing if 1 works");
                        break;
                    }
                    case 2: {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("just seeing if 2 works");
                        break;
                    }
                    case 3: {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("just seeing if 3 works");
                        break;
                    }
                    case 4: {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("just seeing if 4 works");
                        break;
                    }
                    case 5: {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("just seeing if 5 works");
                        break;
                    }
                    default: break;
                }

            } catch(NumberFormatException | IOException ex){
                System.out.println(ex.getMessage());
            }
        }
=======
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
>>>>>>> 92ef3ec04654900ce123a1da6f220d9c6de1ff9b

    }

    public static void displayMenu(){

        System.out.println("Choose your action: \n" +
<<<<<<< HEAD
                "1) Add income \n" +
                "2) Add Purchase \n" +
                "3) Show list of purchases \n" +
                "4) Balance \n" +
                "5) Save \n" +
                "0) Exit ");
    }



}
=======
                           "1) Add income \n" +
                           "2) Add Purchase \n" +
                           "3) Show list of purchases \n" +
                           "4) Balance \n" +
                           "5) Save \n" +
                           "0) Exit ");

    }

}
>>>>>>> 92ef3ec04654900ce123a1da6f220d9c6de1ff9b
