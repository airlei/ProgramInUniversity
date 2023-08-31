package homework4;

public class ConcreateBlack implements FactoryColor{

    @Override
    public AbstractMan createMan() {
        return new BlackMan();
    }

    @Override
    public AbstractWoman createWoman() {

        return new BlackWoman();
    }
}
