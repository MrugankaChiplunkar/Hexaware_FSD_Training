package Payment;

public class PaymentSystem {
    public static void main(String[] args) {
        double amount = 1000;

        Payment upi = (amt) -> amt - (amt * 0.05);          
        Payment cash = (amt) -> amt - (amt * 0.10);         
        Payment creditCard = (amt) -> amt - (amt * 0.04);   
        Payment other = (amt) -> amt - (amt * 0.02);        

        System.out.println("Original Amount: " + amount);
        System.out.println("UPI Payment: " + upi.calBill(amount));
        System.out.println("Cash Payment: " + cash.calBill(amount));
        System.out.println("Credit Card Payment: " + creditCard.calBill(amount));
        System.out.println("Other Payment: " + other.calBill(amount));
    }
}
