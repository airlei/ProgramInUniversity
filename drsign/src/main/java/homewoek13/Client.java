package homewoek13;

public class Client {
    public static void main(String[] args) {
        Piece p1,p2,p3,p4,p5;
        PieceFactory pieceFactory = new PieceFactory();

        p1 = pieceFactory.getPiece("黑");
        p1.location(new Position("第一个位置"));


        p2 = pieceFactory.getPiece("白");
        p2.location(new Position("第二个位置"));


        p3 = pieceFactory.getPiece("黑");
        p3.location(new Position("第三个位置"));


        p4 = pieceFactory.getPiece("白");
        p4.location(new Position("第四个位置"));


        p5 = pieceFactory.getPiece("黑");
        p5.location(new Position("第五个位置"));

        System.out.println("Total Piece:   "+pieceFactory.getTotalPiece());
        System.out.println("Total Position:   "+pieceFactory.getTotalPosition());


    }








}
