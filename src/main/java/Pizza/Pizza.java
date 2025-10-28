package Pizza;

public class Pizza extends Object {
    private String size;
    private String toppings;

    public Pizza(String size, String toppings) {
        this.size = size;
        this.toppings = toppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", toppings='" + toppings + '\'' +
                '}';
    }
}