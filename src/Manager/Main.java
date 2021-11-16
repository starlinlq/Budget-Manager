package Manager;
import java.io.*;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UserCollection collection = new UserCollection();
    static String path = "/Users/starlinlq/Desktop/Budget Manager/Budget-Manager/src/Manager/purchases.txt";
    static User user;
    static Double tax = .08;
    static int userResponse;

    public static void readObj(){
        try{
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            collection = (UserCollection) in.readObject();
        } catch (IOException | ClassNotFoundException ex){
           // System.out.println(ex.getMessage());
        }
    }

    public static void writeObj(){
        try{
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(collection);
            System.out.println("Changes saved \n");
        } catch(IOException ex){
          //  System.out.println(ex.getMessage());
          //  ex.printStackTrace();
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
                        displayPurchases();
                        break;
                    }
                    case 4: {
                        balance();
                        break;
                    }

                    case 5: {
                        analyze();
                        break;
                    }
                    case 6: {
                        writeObj();
                        break;
                    }
                    case 0: {
                        System.exit(0);
                        break;
                    }
                    default:
                        System.out.println("Wrong selection");
                }

            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void analyze(){

        List<Item> list = new ArrayList<>();

        for(var key: user.getList().keySet()){
            list.add(new Item(key, getTotalExpenses(key)));
        }

        Collections.sort(list);

        for(var item : list){
            System.out.println(item.name+" $" +item.value);
        }
        System.out.println("");

    }

    private static double getTotalExpenses(String name){
        var items = user.getExpenses(name);
        var spending = 0;
        for(var key : items.keySet()){
            spending += items.get(key);
        }
        return spending;
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
                "5) Analyze spending \n" +
                "6) Save \n" +
                "0) Exit ");
    }

    public static void setIncome(){
        System.out.println("Enter Income");
        try {
            double income = Double.parseDouble(scanner.nextLine());
            user.setIncome(income);
            System.out.println("Income was added \n");

        } catch(NumberFormatException ex){
            System.out.println("Wrong number format");
        }
    }

    public static void balance(){
        System.out.println(user.getBalance());
    }

    public static void createCategory(){
        System.out.println("Please enter category name");
        String category = scanner.nextLine();
        user.createCategory(category);
        System.out.println("Category created");
    }



    public static void makeAPurchase(){
        System.out.println("""
                1. Display categories.\s
                2. Create new category\s
                3. Go Back""");

        try {
            int input = Integer.parseInt(scanner.nextLine());

            if(input == 2){
                createCategory();
                makeAPurchase();
                return;
            } else if (input == 3){
                return;
            } else if (input < 1 || input > 3){
                System.out.println("Invalid selection, try again \n");
                makeAPurchase();
                return;
            }
        } catch (NumberFormatException ex){
            System.out.println("Invalid number");
            makeAPurchase();
            return;
        }

        while (true) {
            String itemName = "";
            double itemPrice;
            List<String> categories = new ArrayList<>();
            boolean isValid = false;
            System.out.println("Select a category");
            int i = 1;

            for(var key: user.getList().keySet()){
                categories.add(key);
                System.out.println(i+")" + " " + key + " ");
                i++;
            }
            System.out.println("0) Go back");
            System.out.print("> ");

            userResponse = Integer.parseInt(scanner.nextLine());
            if(userResponse == 0){
                makeAPurchase();
                break;
            }

            String selected = categories.get(userResponse  - 1);

            while (!isValid) {
                try{
                    System.out.println("Enter item name");
                    itemName = scanner.nextLine();
                    System.out.println("Enter price");
                    itemPrice = Double.parseDouble(scanner.nextLine());
                    user.addExpense(selected, itemName, itemPrice + (itemPrice * tax));
                    System.out.println("Expense added \n");
                    isValid = true;

                } catch(NumberFormatException ex){
                    System.out.println("Invalid input, Please try again");
                }

            }
        }
    }

    static void displayPurchases(){
        List<String> categories = new ArrayList<>();
        System.out.println("Select a category");
        int i = 1;

        for(var key: user.getList().keySet()){
            categories.add(key);
            System.out.println(i+")" + " " + key + " ");
            i++;
        }

        System.out.println("0) Go back");
        System.out.print("> ");

        userResponse = Integer.parseInt(scanner.nextLine());
        if(userResponse == 0){
            return;
        }

        String selected = categories.get(userResponse  - 1);
        HashMap<String, Double> purchases = user.getExpenses(selected);

       if(purchases != null){
          if(purchases.size() > 0){
              for(String key: purchases.keySet()){
                  System.out.println("- "+key+" "+purchases.get(key));
              }
              System.out.println("");
          } else
              System.out.println("No purchases made yet");
       } else
           System.out.println("Wrong selection");

    }
}