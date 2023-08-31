package homework11;

public class Complexphone extends Changer{
    public Complexphone(Update update) {
        super(update);
        System.out.println("升级为Complexphone");
    }
    public void shake(){
        System.out.println("可以震动");
    }
    public void light(){

        System.out.println("灯光闪烁提示");
    }
}
