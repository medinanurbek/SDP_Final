package bridge;

public abstract class Payment {
    protected PaymentGateway gateway;
    protected Payment(PaymentGateway gateway) { this.gateway = gateway; }
    public abstract void process(double amount);
}