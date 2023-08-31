package adapter;

public class ConcreteDog implements Dog{
    @Override
    public void woof() {
        System.out.println("汪汪叫");
    }
}
