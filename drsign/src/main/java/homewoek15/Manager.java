package homewoek15;

public class Manager extends Leader{
    public Manager(String name)
    {
        super(name);
    }

    @Override
    public void handleRequest(MoneyRequest request) {
        if(request.getMoney()<=50000){
            System.out.println("部门经理" + name + "审核" + request.getMoney() + "元的采购单，采购物资为" + request.getThings());
        }else {
            if (this.successor != null) {
                this.successor.handleRequest(request);
            }

        }
    }
}
