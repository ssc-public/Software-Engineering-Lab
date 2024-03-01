package PaymentServices;

public class OnlineOrderService implements OrderService {
    @Override
    public void onSiteOrderRegister(String customerName) {
        //Empty Body!
    }

    @Override
    public void onlineOrderRegister(String customerName) {
        System.out.println("online order registered for " + customerName);
    }

    @Override
    public void onSiteOrderPayment(int foodPrice) {
        //Empty Body
    }

    @Override
    public void onlineOrderPayment(int foodPrice) {
        System.out.println("online Payment with Price : " + foodPrice + " Tomans!");
    }

}
