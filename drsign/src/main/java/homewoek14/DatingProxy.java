package homewoek14;

public class DatingProxy implements AbstractDating{
    private  String name;
    private int age;
    private RealDating realDating = new RealDating();

    @Override
    public void dating() {
            if (18>age){
                System.out.println("姓名:"+name);
                System.out.println("年龄:"+age);
                System.out.println("对不起，不能早恋！");
            }else {
                System.out.println("您好" + name + ",您已经成年可以相亲");
            }
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void serName(String name) {
        this.name = name;
    }
}
