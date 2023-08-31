package homework12;

public class HardDisk {

    public boolean on(){
        read();

        return true;
    }

    public void off(){
        System.out.println("关闭HardDisk");
    }
    public void read(){
        System.out.println("HardDisk读取正常");
    }
}
