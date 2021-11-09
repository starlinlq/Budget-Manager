package Manager;
import java.io.*;
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
                        System.out.println("just seeing if 1 works");
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

    public static void savePurchases(String userName) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Manager/purchases.txt"));
            writer.write(user.getName());
            writer.write(user.getBalance());
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
