package adapter;

public class ConcreteCat implements Cat{

    @Override
    public void catchMouse() {
        System.out.println("抓老鼠");
    }
}
