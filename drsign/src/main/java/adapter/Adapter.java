package adapter;

public class Adapter implements Cat,Dog{

    private Dog dog;
    private Cat cat;

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void catchMouse() {
        System.out.println("猫学狗");
        dog.woof();
    }

    @Override
    public void woof() {
        System.out.println("狗学猫");
        cat.catchMouse();
    }
}
