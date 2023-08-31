package homewoek13;

import java.util.ArrayList;

public class PieceFactory {
    private  ArrayList pieces = new ArrayList();
    private int totalPosition = 0;

    public PieceFactory() {
        Piece black = new Black("黑");
        pieces.add(black);
        Piece white = new White("白");
        pieces.add(white);
    }

    public Piece getPiece(String color){

        if (color.equals("黑")){
            totalPosition++;
            return (Piece)pieces.get(0);
        }else if(color.equals("白")){
            totalPosition++;
            return (Piece)pieces.get(1);
        }else {
            return null;
        }
    }

    public int getTotalPiece(){
        return pieces.size();
    }
    public int getTotalPosition(){
        return totalPosition;
    }

}
