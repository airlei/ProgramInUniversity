package homework5;

public class BuilderDesktop extends BuilderComputer{
    @Override
    public void buildCpu() {
        computer.setCpu("正在组装台式电脑CPU");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("正在组装台式电脑内存");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("正在组装台式机硬盘");
    }

    @Override
    public void buildHost() {
        computer.setHost("正在组装台式主机");
    }


}
