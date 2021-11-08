package Manager;

public class Main {

    //purchases.txt
    //User
    //userCollection - is going to save all the users created -
    //      //     / - save in the file
    //hashmap key-values (name (key), price (value)) for the categories, and users
    //


    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu(){
        System.out.println("Choose your action: \n" +
                           "1) Add income \n" +
                           "2) Add Purchase \n" +
                           "3) Show list of purchases \n" +
                           "4) Balance \n" +
                           "5) Save \n" +
                           "6) Load  \n" +
                           "0) Exit ");
    }
}
