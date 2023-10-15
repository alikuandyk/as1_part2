// Реализуем конкретную стратегию оплаты
class QiwiPaymentStrategy implements PaymentStrategy {
    private String phoneNumber;

    public QiwiPaymentStrategy(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment of " + amount + " using Qiwi with phone number " + phoneNumber);
    }
}