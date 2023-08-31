package homewoek14;

public class Client {

    public static void main(String[] args) {
        AbstractDating abstractDating;
        abstractDating = new DatingProxy();

        abstractDating.serName("小红");
        abstractDating.setAge(16);
        abstractDating.dating();
    }



}
