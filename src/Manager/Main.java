package Manager;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UserCollection collection = new UserCollection();
    static String path = "Manager/purchases.txt";
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
                        char c = '\n';
                        int length = 25;
                        char[] chars = new char[length];
                        Arrays.fill(chars, c);
                        System.out.print(String.valueOf(chars));
                        Runtime.getRuntime().exec("clear");
                        setIncome();
                        break;
                    }
                    case 2: { //add purchase
                        char c = '\n';
                        int length = 25;
                        char[] chars = new char[length];
                        Arrays.fill(chars, c);
                        System.out.print(String.valueOf(chars));
                        Runtime.getRuntime().exec("clear");
                        makeAPurchase();
                        break;
                    }
                    case 3: { //show purchases
                        char c = '\n';
                        int length = 25;
                        char[] chars = new char[length];
                        Arrays.fill(chars, c);
                        System.out.print(String.valueOf(chars));
                        Runtime.getRuntime().exec("clear");
                        System.out.println("Current balance: ");
                        user.getBalance();
                        System.out.println("Current purchases: ");
                        readObj();
                        StringBuilder sb = new StringBuilder();
                        String line;
                        BufferedReader FileReader = new BufferedReader(new FileReader("Manager/purchases.txt"));
                        while ((line = FileReader.readLine()) != null) {
                            sb.append(line);
                            System.out.println(line);
                        }

                        break;
                    }
                    case 4: {
                        char c = '\n';
                        int length = 25;
                        char[] chars = new char[length];
                        Arrays.fill(chars, c);
                        System.out.print(String.valueOf(chars));
                        Runtime.getRuntime().exec("clear");
                        balance();
                        break;
                    }
                    case 5: {
                        char c = '\n';
                        int length = 25;
                        char[] chars = new char[length];
                        Arrays.fill(chars, c);
                        System.out.print(String.valueOf(chars));
                        Runtime.getRuntime().exec("clear");
                        writeObj();
                        break;
                    }
                    default:
                        break;
                }

            } catch (NumberFormatException | IOException ex) {
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