package observer;

public class CartObserver implements Observer {
    private String observerName;

    public CartObserver(String name) {
        this.observerName = name;
    }

    @Override
    public void update(String message) {
        System.out.println("[" + observerName + "] " + message);
    }
}