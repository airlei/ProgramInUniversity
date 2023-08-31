package homework5;

public class Cilent {
    public static void main(String[] args) {
       BuilderDesktop desktop = new BuilderDesktop();
       BuilderLaptop laptop = new BuilderLaptop();

        Director director = new Director();
        director.setBuildComputer(desktop);

        Computer computer = director.construct();

        System.out.println(computer.getCpu());
        System.out.println(computer.getMemory());
        System.out.println(computer.getHardDisk());
        System.out.println(computer.getHost());
        System.out.println("电脑组装完成");
    }
}
