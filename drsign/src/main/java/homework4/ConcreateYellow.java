package homework4;

public class ConcreateYellow  implements FactoryColor{
    @Override
    public AbstractMan createMan() {
        return new YellowMan();
    }

    @Override
    public AbstractWoman createWoman() {
        return new YellowWoman();
    }
}
