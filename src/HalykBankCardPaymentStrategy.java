// Реализуем конкретную стратегию оплаты
class HalykBankCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;

    public HalykBankCardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment of " + amount + " using Halyk Bank card " + cardNumber);
    }
}