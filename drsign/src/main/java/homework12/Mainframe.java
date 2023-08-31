package homework12;

public class Mainframe {

    private CPU cpu;
    private HardDisk hardDisk;
    private OS os;
    private Memory memory;


    public Mainframe() {
        cpu = new CPU();
        hardDisk = new HardDisk();
        os = new OS();
        memory = new Memory();
    }

    public void on(){

        System.out.println("开启计算机**************************");
        if (memory.on()){
            System.out.println("Memory运行成功");
            if (cpu.on()){
                System.out.println("cpu运行成功");
                if (hardDisk.on()){
                    System.out.println("HardDisk运行成功");
                    if(os.on()){
                        System.out.println("OS运行成功");
                        System.out.println("计算机开机成功");
                    }
                }
            }
        }else {
            System.out.println("计算机开启失败");
        }
    }

    public  void off(){
        System.out.println("关闭计算机");
        memory.off();
        cpu.off();
        hardDisk.off();
        os.off();
    }
}
