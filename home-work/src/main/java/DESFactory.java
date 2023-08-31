
public class DESFactory implements MethodFactory {
    public DES produceMethod() {
        System.out.println("使用DES算法");
        return new DES();
    }
}