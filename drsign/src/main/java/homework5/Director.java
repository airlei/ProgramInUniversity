package homework5;

public class Director {
    private BuilderComputer bc ;
    public void setBuildComputer(BuilderComputer bc){
        this.bc=bc;
    }
    public Computer construct(){
        bc.buildCpu();
        bc.buildMemory();
        bc.buildHardDisk();
        bc.buildHost();
        return bc.getComputer();

    }

}
