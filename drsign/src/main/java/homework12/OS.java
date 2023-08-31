package homework12;

public class OS {
    public boolean on(){
        load();

        return true;
    }

    public void off(){
        System.out.println("关闭OS");
    }
    public void load(){
        System.out.println("OS载入正常");
    }

}
