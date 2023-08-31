package homework4;

public class Cilent {
    public static void main(String[] args) {
        FactoryColor fc = new ConcreateYellow();
        AbstractMan am;
        AbstractWoman aw;
        am = fc.createMan();
        am.makeM();
        aw = fc.createWoman();
        aw.makew();
    }


}
