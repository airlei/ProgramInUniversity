package homework11;

public class Changer implements Update{

    private Update update ;

    public Changer(Update update) {
        this.update = update;
    }

    @Override
    public void sound() {
        update.sound();
    }
}
