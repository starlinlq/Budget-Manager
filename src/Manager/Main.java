package Manager;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UserCollection collection = new UserCollection();
    static String path = "C:\\Users\\amcmu\\IdeaProjects\\Budget-Manager\\src\\Manager\\purchases.txt";
    static User user;

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
        readObj();
        getUser();


        while (true) {
            try {
                displayMenu();
                int opt = Integer.parseInt(scanner.nextLine());
                switch (opt) {
                    case 1: {
                        setIncome();
                        break;
                    }
                    case 2: { //add purchase
                        makeAPurchase();
                        break;
                    }
                    case 3: { //show purchases
                        System.out.println("Current balance: ");
                        user.getBalance();
                        System.out.println("Choose a category.");
                        System.out.println("1. Food");
                        System.out.println("2. Clothes");
                        System.out.println("3. Entertainment");
                        System.out.println("4. Other");
                        int userChoice = Integer.parseInt(scanner.nextLine());
                        if(userChoice == 1) {
                            HashMap<String, Double> purchases = user.getExpenses("Food");
                            if(purchases != null) {
                                System.out.println(purchases.values());
                            }else{
                                System.out.println("No purchases made yet!");
                            }
                        }
                        if(userChoice == 2) {
                            HashMap<String, Double> purchases = user.getExpenses("Clothes");
                            if(purchases != null) {
                                System.out.println(purchases.values());
                            }else{
                                System.out.println("No purchases made yet!");
                            }
                        }
                        if(userChoice == 3) {
                            HashMap<String, Double> purchases = user.getExpenses("Entertainment");
                            if(purchases != null) {
                                System.out.println(purchases.values());
                            }else{
                                System.out.println("No purchases made yet!");
                            }
                        }
                        if(userChoice == 4) {
                            HashMap<String, Double> purchases = user.getExpenses("Other");
                            if(purchases != null) {
                                System.out.println(purchases.values());
                            }else{
                                System.out.println("No purchases made yet!");
                            }
                        }

                        break;
                    }
                    case 4: {
                        balance();
                        break;
                    }
                    case 5: {
                        writeObj();
                        break;
                    }
                    default:
                        break;
                }

            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void getUser(){
        System.out.println("Please enter user name");
        System.out.print("> ");
        String name = scanner.nextLine();

        if(collection.getUser(name) != null){
            user = collection.getUser(name);
            System.out.println("Welcome back "+ user.getName());
        } else {
            User newUser = new User(name, 0);
            collection.addUser(newUser);
            user = newUser;
            System.out.println("Welcome " + name);
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

    public static void setIncome(){
        System.out.println("Enter Income");
        try {
            int income = Integer.parseInt(scanner.nextLine());
            user.setIncome(income);
            System.out.println("Income was added");

        } catch(NumberFormatException ex){
            System.out.println("Wrong number format");
        }

    }

    public static void balance(){
        System.out.println(user.getBalance());
    }

    public static void makeAPurchase(){
        String category = "";
        String itemName = "";
        boolean isValid = false;
        double itemPrice;
        while(!isValid) {
            System.out.println("Choose a purchase category.");
            System.out.println("1. Food");
            System.out.println("2. Clothes");
            System.out.println("3. Entertainment");
            System.out.println("4. Other");
            System.out.println("5. Go back");
            System.out.print("> ");
            int userResponse = Integer.parseInt(scanner.nextLine());

            switch (userResponse) {
                case 1: {
                    category = "Food";
                    System.out.println("Enter item name");
                    itemName = scanner.nextLine();
                    System.out.println("Enter price");
                    itemPrice = scanner.nextDouble();
                    user.addExpense(category, itemName, itemPrice);
                    isValid = true;
                    break;
                }
                case 2: {
                    category = "Clothes";
                    System.out.println("Enter item name");
                    itemName = scanner.nextLine();
                    System.out.println("Enter price");
                    itemPrice = scanner.nextDouble();
                    user.addExpense(category, itemName, itemPrice);
                    isValid = true;
                    break;
                }
                case 3: {
                    category = "Entertainment";
                    System.out.println("Enter item name");
                    itemName = scanner.nextLine();
                    System.out.println("Enter price");
                    itemPrice = scanner.nextDouble();
                    user.addExpense(category, itemName, itemPrice);
                    isValid = true;
                    break;
                }
                case 4: {
                    category = "Other";
                    System.out.println("Enter item name");
                    itemName = scanner.nextLine();
                    System.out.println("Enter price");
                    itemPrice = scanner.nextDouble();
                    user.addExpense(category, itemName, itemPrice);
                    isValid = true;
                    break;
                }
                case 5: {
                    category = "Other";
                    System.out.println("Enter item name");
                    itemName = scanner.nextLine();
                    System.out.println("Enter price");
                    itemPrice = scanner.nextDouble();
                    user.addExpense(category, itemName, itemPrice);
                    isValid = true;
                }
                default: {
                    System.out.println("Please make a valid selection. \n");
                }

            }
        }

    }


}