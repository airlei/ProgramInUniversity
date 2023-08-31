package homework5;

public abstract class BuilderComputer {
    protected Computer computer = new Computer();
    public abstract void buildCpu();
    public abstract void buildMemory();
    public abstract void buildHardDisk();
    public abstract void buildHost();

    public Computer getComputer(){
        System.out.println("正在组装电脑");
        return computer;
    }

}
