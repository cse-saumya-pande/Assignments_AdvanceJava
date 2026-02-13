package junitAssignment1;

public class CartService {

    // 1️⃣ Calculate Total Price
    public double calculateTotal(double item1,
                                 double item2,
                                 double item3) {

        return item1 + item2 + item3;
    }

    // 2️⃣ Calculate Discount
    public double calculateDiscount(double total) {

        if (total >= 5000) {
            return total * 0.10;   // 10% discount
        }

        return 0;
    }

    // 3️⃣ Final Payable Amount
    public double calculateFinalAmount(double total,
                                       double discount) {

        return total - discount;
    }
}