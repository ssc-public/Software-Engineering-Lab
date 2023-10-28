import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    String customerName;
    ArrayList<Food> foods = new ArrayList<>();
    LocalDateTime orderDate= LocalDateTime.now();

    public Order(String customerName){
        this.customerName= customerName;
    }

    public void addItem(Food food){
        this.foods.add(food);
    }

    public int getTotalPrice(){
        int price= this.foods.stream().mapToInt(food -> food.price).sum();
        return price;
    }

    @Override
    public String toString() {
        String orders ="";
        for (Food food:this.foods) {
            orders+= food.foodName + " -> " + food.price+"\n";
        }
        return "Customer : " + customerName + "\nOrders are : \n" + orders + "\nTotal Price : " + this.getTotalPrice();
    }
}
