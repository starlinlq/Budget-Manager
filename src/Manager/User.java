package Manager;

import java.util.HashMap;

public class User {
    private String name;
    private double income;
    private double expensesTotal = 0;

    HashMap<String, HashMap<String, Double>> list = new HashMap<>();

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


    public void setIncome(double income) {
        this.income = income;
    }


    public void addExpense(String key, String name, double price) {
        var expense = this.list.get(key);

        if(expense == null){
            var newHash = new HashMap<String, Double>();
            newHash.put(name, price);
            this.list.put(key,newHash);
        }

        if(expense != null){
            if (expense.containsKey(name)) {
                expense.put(name, expense.get(name) + price);
            } else
                this.list.get(key).put(name, price);

            this.expensesTotal += price;
        }

    }

    public HashMap<String, Double> getExpenses(String key) {
        return this.list.get(key);
    }

    public double getBalance() {  //this on should be cast to a different variable type?
        return income - expensesTotal;
    }

    public double getIncome() {
        return income;
    }
}

