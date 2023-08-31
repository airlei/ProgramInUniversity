package homewoek15;

public abstract class Leader {
    public String name;
    public Leader successor;

    public Leader(String name) {
        this.name = name;
    }

    public void setSuccessor(Leader successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(MoneyRequest request);
}
