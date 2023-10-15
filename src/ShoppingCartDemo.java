import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        List<Product> availableProducts = new ArrayList<>();
        availableProducts.add(new Product("Item 1", 10.0));
        availableProducts.add(new Product("Item 2", 5.0));
        availableProducts.add(new Product("Item 3", 8.0));

        while (true) {
            System.out.println("Choose a product to add to the cart (1, 2, 3) or enter 'checkout' to complete the purchase:");
            System.out.println("1. Item 1 (Price: $10.0)");
            System.out.println("2. Item 2 (Price: $5.0)");
            System.out.println("3. Item 3 (Price: $8.0)");
            System.out.print("Your choice: ");

            String choice = scanner.next();

            if (choice.equals("checkout")) {
                break;
            }

            try {
                int productChoice = Integer.parseInt(choice) - 1;
                if (productChoice >= 0 && productChoice < availableProducts.size()) {
                    Product selectedProduct = availableProducts.get(productChoice);
                    System.out.print("Enter the quantity: ");
                    int quantity = scanner.nextInt();
                    cart.addProduct(selectedProduct, quantity);
                    System.out.println("Added " + selectedProduct.getName() + " (" + quantity + " units) to the cart.");
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice.");
            }
        }

        System.out.println("Total price in the cart: " + cart.calculateTotalPrice());

        System.out.println("Choose a payment strategy: 1 for Halyk Bank Card, 2 for Qiwi");
        int paymentChoice = scanner.nextInt();

        PaymentStrategy paymentStrategy;

        if (paymentChoice == 1) {
            System.out.print("Enter your Halyk Bank card number: ");
            String cardNumber = scanner.next();
            paymentStrategy = new HalykBankCardPaymentStrategy(cardNumber);
        } else if (paymentChoice == 2) {
            System.out.print("Enter your Qiwi phone number: ");
            String phoneNumber = scanner.next();
            paymentStrategy = new QiwiPaymentStrategy(phoneNumber);
        } else {
            System.out.println("Invalid payment choice. Using default payment strategy.");
            paymentStrategy = new HalykBankCardPaymentStrategy("1234-5678-9012-3456");
        }

        cart.checkout(paymentStrategy);
    }
}