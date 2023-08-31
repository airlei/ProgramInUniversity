package homewoek13;

public class Black implements Piece{

    private String color = "黑";

    @Override
    public void location(Position position) {
        System.out.println( this.color + "棋，坐落于" + position.getPosition());
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public Black(String color) {
        this.color = color;
    }
}
