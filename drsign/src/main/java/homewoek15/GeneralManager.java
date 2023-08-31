package homewoek15;

public class GeneralManager extends Leader{
    public GeneralManager(String name)
    {
        super(name);
    }

    @Override
    public void handleRequest(MoneyRequest request) {
        if(request.getMoney()<=200000){
            System.out.println("总经理" + name + "审核" + request.getMoney() + "元的采购单，采购物资为" + request.getThings());
        }else {
            System.out.println( request.getMoney() + "元的采购单，采购物资为" + request.getThings()+"需要开员工大会决定");

        }
    }
}
