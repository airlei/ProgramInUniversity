package homewoek15;

public class Director extends Leader{
    public Director(String name)
    {
        super(name);
    }

    @Override
    public void handleRequest(MoneyRequest request) {
        if(request.getMoney()<=10000){
            System.out.println("主任" + name + "审核" + request.getMoney() + "元的采购单，采购物资为" + request.getThings());
        }else {
            if (this.successor != null) {
                this.successor.handleRequest(request);
            }

        }
    }
}
