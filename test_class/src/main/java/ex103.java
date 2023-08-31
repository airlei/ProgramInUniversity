import java.util.Random;
import java.util.Scanner;
public class ex103 {
    static Scanner sc;
    static double money;
    static String goods;
    static String e;
    public static void toubi() {
        sc=new Scanner(System.in);
        System.out.print("请投币：");
        money=sc.nextDouble();
        if(money==0.5) {
            pentagon();
        }else if(money==1){
            System.out.print("请选择橙汁还是啤酒：");
            goods=sc.next();
            if(goods.equals("橙汁")) {
                System.out.println("恭喜您购买成功！您选择了橙汁！给您找零5角钱！");
                return;
            }else if(goods.equals("啤酒")) {
                System.out.println("恭喜您购买成功！您选择了啤酒！给您找零5角钱！");
                return;
            }else {
                System.out.println("对不起！此柜无此货源！");
                return;
            }
        }else {
            System.out.println("投币错误！");
        }
    }
//投入五角时机器反应
    public static void pentagon() {
        System.out.print("请选择橙汁还是啤酒：");
        goods=sc.next();
        if(goods.equals("橙汁")) {
            System.out.println("恭喜您购买成功！您选择了橙汁！");
            return;
        }else if(goods.equals("啤酒")) {
            System.out.println("恭喜您购买成功！您选择了啤酒！");
            return;
        }else {
            System.out.println("对不起！此柜无此货源！");
            return;
        }
    }

    public static void main(String[] args) {
                toubi();

    }
}