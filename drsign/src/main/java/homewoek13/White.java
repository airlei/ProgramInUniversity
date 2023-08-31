package homewoek13;

public class White implements Piece{

    private String color = "白";
    @Override
    public void location(Position position) {
        System.out.println( this.color + "棋，坐落于" + position.getPosition());
    }

    @Override
    public String getColor() {
        return null;
    }

    public White(String color) {
        this.color = color;
    }
}
