package java8;

@FunctionalInterface
public interface Payment {
    int calBill(int amt);

    default int diwaliDiscount(int amt) {
        return amt - (amt * 5 / 100);
    }
}

package java8;

public class Main {
    public static void main(String[] args) {
        int amt = 1000;

        Payment upi = (amount) -> amount - (amount * 5 / 100);
        Payment cash = (amount) -> amount - (amount * 10 / 100);
        Payment creditCard = (amount) -> amount - (amount * 4 / 100);
        Payment others = (amount) -> amount - (amount * 2 / 100);

        System.out.println("Original Amount: " + amt);

        System.out.println("UPI Bill: " + upi.calBill(amt));
        System.out.println("Cash Bill: " + cash.calBill(amt));
        System.out.println("Credit Card Bill: " + creditCard.calBill(amt));
        System.out.println("Others: " + others.calBill(amt));
        System.out.println();

        System.out.println("UPI + Diwali Discount: " + upi.diwaliDiscount(upi.calBill(amt)));
        System.out.println("Cash + Diwali Discount: " + cash.diwaliDiscount(cash.calBill(amt)));
        System.out.println("Credit Card + Diwali Discount: " + creditCard.diwaliDiscount(creditCard.calBill(amt)));
        System.out.println("Other Payment + Diwali Discount: " + others.diwaliDiscount(others.calBill(amt)));
    }
}
