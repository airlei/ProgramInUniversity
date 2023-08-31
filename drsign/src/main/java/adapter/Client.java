package adapter;

public class Client {


    public static void main(String[] args) {
        Cat cat = new ConcreteCat();
        Dog dog = new ConcreteDog();

        Adapter adapter = new Adapter();

        adapter.setCat(cat);
        adapter.woof();
        System.out.println("************************");
        adapter.setDog(dog);
        adapter.catchMouse();

    }

}
