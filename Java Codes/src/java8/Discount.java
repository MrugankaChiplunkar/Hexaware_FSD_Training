package java8;

interface DiscountAmt {
    default double applyDiscount(double amount) {
        return amount - (amount * 0.05);  
    }
}

class Person implements DiscountAmt {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public void discountedBill(double amount) {
        double finalAmount = applyDiscount(amount);
        System.out.println(name+" discounted amount: "+ finalAmount);
    }
}

public class Discount {
    public static void main(String[] args) {
        Person p1 = new Employee("ABC");
        p1.discountedBill(10000);
    }
}
