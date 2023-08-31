package homewoek15;

public class Client {
    public static void main(String[] args) {
        Leader objDirector,objManager,objGeneralManager,objAssistantManager;
        objDirector = new Director("张三");
        objManager = new Manager("李四");
        objAssistantManager = new AssistantManager("王五");
        objGeneralManager = new GeneralManager("赵六");


        objDirector.setSuccessor(objManager);
        objManager.setSuccessor(objAssistantManager);
        objAssistantManager.setSuccessor(objGeneralManager);

        MoneyRequest one = new MoneyRequest(150000,"电脑");
        objDirector.handleRequest(one);

        MoneyRequest two = new MoneyRequest(80000,"空调");
        objDirector.handleRequest(two);

        MoneyRequest three = new MoneyRequest(999999999,"A4纸");
        objDirector.handleRequest(three);

    }



}
