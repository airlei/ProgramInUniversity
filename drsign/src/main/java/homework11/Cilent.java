package homework11;

public class Cilent {
    public static void main(String[] args) {
        Update update ;
        update=new SimplePhone();
        update.sound();

        System.out.println("升级中**********************");
        JarPhone jarPhone = new JarPhone(update);
        jarPhone.sound();
        jarPhone.shake();


        System.out.println("再次升级中**********************");

        Complexphone complexphone = new Complexphone(update);
        complexphone.sound();
        complexphone.shake();
        complexphone.light();


    }
}
