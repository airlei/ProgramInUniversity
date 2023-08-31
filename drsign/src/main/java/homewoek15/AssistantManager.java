package homewoek15;

public class AssistantManager extends Leader{
    public AssistantManager(String name)
    {
        super(name);
    }

    @Override
    public void handleRequest(MoneyRequest request) {
        if(request.getMoney()<=100000){
            System.out.println("副经理" + name + "审核" + request.getMoney() + "元的采购单，采购物资为" + request.getThings());
        }else {
            if (this.successor != null) {
                this.successor.handleRequest(request);
            }

        }
    }
}
