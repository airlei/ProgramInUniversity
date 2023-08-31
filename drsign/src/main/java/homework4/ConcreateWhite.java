package homework4;

public class ConcreateWhite  implements FactoryColor{
    @Override
    public AbstractMan createMan() {
        return new WhiteMan();
    }

    @Override
    public AbstractWoman createWoman() {
        return new WhiteWoman();
    }
}
