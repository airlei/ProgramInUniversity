
public class IDEAFactory implements MethodFactory {
    public IDEA produceMethod() {
        System.out.println("使用IDEA算法");
        return new IDEA();
    }
}
