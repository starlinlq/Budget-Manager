package Manager;

public class Item implements Comparable<Item> {
    String name;
    double value;

    public Item(String name, double value){
        this.name = name;
        this.value = value;
    }

    @Override
    public int compareTo(Item o) {
        if(this.value > o.value){
            return -1;
        } else if(this.value < o.value){
            return 1;
        }
        return 0;
    }
}
