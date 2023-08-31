package homewoek15;

public class MoneyRequest {
    public int money;
    public String things;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }

    public MoneyRequest(int money, String things) {
        this.money = money;
        this.things = things;
    }
}
