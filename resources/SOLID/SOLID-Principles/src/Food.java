public class Food {
    String foodName;
    int price;
    int quantity =1;

    Food(String foodName, int foodPrice){
        this.foodName = foodName;
        this.price = foodPrice;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getFoodName() {
        return foodName;
    }
}
