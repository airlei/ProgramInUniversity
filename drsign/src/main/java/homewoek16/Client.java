package homewoek16;

public class Client {
    public static void main(String[] args) {
        CalculatorForm form = new CalculatorForm();
        AddCommand command = new AddCommand();
        form.setCommand(command);
        //计算
        System.out.println("------计算过程------");
        form.compute(1);
        form.compute(2);
        form.compute(3);
        form.compute(4);
        //多次撤回
        System.out.println("------撤回过程------");
        form.undo();
        form.undo();
        form.undo();
        form.undo();
        form.undo();
        //多次恢复
        System.out.println("------恢复过程------");
        form.redo();
        form.redo();
        form.redo();
        form.redo();
        form.redo();
    }
}