package Manager;

import java.util.HashMap;

public class User {
    private String name;
    private int income;
    private int balance;
    private int expensesTotal;

    HashMap<String, HashMap<String, Integer>> list = new HashMap<>();

    User(String name, int income, int balance){
        this.name = name;
        this.income = income;
        this.balance= balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setIncome(int income) {
        this.income = income;
    }

<<<<<<< HEAD
    public void addExpense(String key, String name, int price){
        var expense = this.list.get(key);

        if(expense.containsKey(name)){
            expense.put(name, expense.get(name) + price);
        } else
            this.list.get(key).put(name, price);

=======
    public void addExpense(String key, String name, int price) {
        var expense = this.list.get(key);

        if(expense.containsKey(name)){
            expense.put(name, expense.get(name) + price);
        } else
            this.list.get(key).put(name, price);

        this.expensesTotal += price;
>>>>>>> 92ef3ec04654900ce123a1da6f220d9c6de1ff9b
    }

    public HashMap<String, Integer> getExpenses(String key) {
        return this.list.get(key);
    }

    public int getBalance() {
<<<<<<< HEAD

        return balance;
=======
        return balance - expensesTotal;
>>>>>>> 92ef3ec04654900ce123a1da6f220d9c6de1ff9b
    }

    public int getIncome() {
        return income;
    }
}

