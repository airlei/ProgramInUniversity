package homework5;

public class BuilderLaptop extends BuilderComputer{
    @Override
    public void buildCpu() {
        computer.setCpu("正在建造笔记本电脑CPU");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("正在建造笔记本电脑内存");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("正在笔记本建造硬盘");
    }

    @Override
    public void buildHost() {
        computer.setHost("正在建造笔记本主机");
    }


}
