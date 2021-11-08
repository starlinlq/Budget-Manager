package Manager;

import java.util.HashMap;

public class User {
    private String name;
    private int income;
    private int expensesTotal = 0;

    HashMap<String, HashMap<String, Integer>> list = new HashMap<>();

    User(String name, int income){
        this.name = name;
        this.income = income;
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


    public void addExpense(String key, String name, int price) {
        var expense = this.list.get(key);

        if (expense.containsKey(name)) {
            expense.put(name, expense.get(name) + price);
        } else
            this.list.get(key).put(name, price);
        this.expensesTotal += price;
    }

    public HashMap<String, Integer> getExpenses(String key) {
        return this.list.get(key);
    }

    public int getBalance() {
        return income - expensesTotal;
    }

    public int getIncome() {
        return income;
    }
}

