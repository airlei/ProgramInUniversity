package homewoek17;

public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String instruction1 = "up move 5 and down run 10 and left move 5";
        String instruction2="down run 10 and left move 20";
        InstructionHandler handler = new InstructionHandler();
        handler.handle(instruction1);
        String outString;
        outString = handler.output();
        System.out.println(outString);
        handler.handle(instruction2);
        outString = handler.output();
        System.out.println(outString);
    }

}