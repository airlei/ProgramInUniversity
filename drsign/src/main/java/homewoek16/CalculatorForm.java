package homewoek16;

public class CalculatorForm {
    private AbstractCommand command;
    public void setCommand(AbstractCommand command) {
        this.command =command;
    }
    /**
     * 执行运算
     * @param value
     */
    public void compute(int value) {
        command.execute(value);
    }
    /**
     * 撤回
     */
    public void undo() {
        int i = command.undo();
        if(i==-1){
            System.out.println("缓存中已不存在数据");
        }else{
            System.out.println("执行成功，运算结果是："+i);
        }
    }
    /**
     * 恢复
     */
    public void redo() {
        int i = command.redo();
        if(i==-1){
            System.out.println("已恢复至最新数据");
        }
        else{
            System.out.println("执行成功，运算结果是："+i);
        }
    }
}