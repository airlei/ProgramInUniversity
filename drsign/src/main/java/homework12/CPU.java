package homework12;

public class CPU {

    public boolean on(){
        run();

        return true;
    }

    public void off(){
        System.out.println("关闭cpu");
    }
    public void run(){
        System.out.println("cpu运行正常");
    }
}
