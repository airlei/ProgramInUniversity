package homework12;

public class Memory {

    public boolean on(){
        check();

        return true;
    }

    public void off(){
        System.out.println("关闭Memory");
    }
    public void check(){
        System.out.println("Memory自检正常");
    }
}
