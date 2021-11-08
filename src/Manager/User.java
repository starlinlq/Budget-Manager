package Manager;

import java.util.HashMap;

public class User {
    private String name = "tom";
    private int income = 0;
    private int balance = 0;
    HashMap<String, HashMap<String, Integer>> list = new HashMap<>();

    User(String name, int income, int balance){
        this.name = name;
        this.income = income;
        this.balance= balance;
    }


}
