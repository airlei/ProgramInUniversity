package homework11;

public class SimplePhone implements Update{

    public SimplePhone() {
        System.out.println("SimplePhone");
    }

    @Override
    public void sound() {
        System.out.println("可以发出声音");
    }
}
