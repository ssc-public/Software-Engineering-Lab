package PaymentServices;

public class OnSiteOrderService implements OrderService {
    @Override
    public void onSiteOrderRegister(String customerName) {
        System.out.println("on-Site order registered for " + customerName);
    }

    @Override
    public void onlineOrderRegister(String customerName) {
        //Empty Body
    }

    @Override
    public void onSiteOrderPayment(int foodPrice) {
        System.out.println("on-Site Payment with Price : " + foodPrice + " Tomans!");
    }

    @Override
    public void onlineOrderPayment(int foodPrice) {
        //Empty Body!
    }
}
