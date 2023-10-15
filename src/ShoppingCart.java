import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        product.setQuantity(quantity);
        products.add(product);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public void checkout(PaymentStrategy paymentStrategy) {
        double totalPrice = calculateTotalPrice();
        paymentStrategy.processPayment(totalPrice);
    }
}