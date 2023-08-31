import java.util.Scanner;

public class ex104 {
    public static void main(String[] args) {
        int flag = 1;
        while(flag!=0){
            Scanner sc = new Scanner(System.in);
            System.out.println("请选择您的航线 欧美(请输入1) 国外非欧美(请输入2) 国内(请输入3)");
            int route = sc.nextInt();
            System.out.println("请选择您的舱位: 商务舱(请选择1) 经济舱(请选择2)");
            int cw = sc.nextInt();
            System.out.println("请选择您的飞行时间: 两小时以内(请选择1) 超过两小时(请选择2)");
            int time = sc.nextInt();
            if(route==1){
                System.out.println("您的仓位有食物供应，且可以播放电影");
            }else if(route==2){
                if(cw==1){
                    System.out.println("您的仓位有食物供应，且可以播放电影");
                }else{
                    System.out.println("您的仓位有食物供应，但不可以播放电影");
                }
            }else {
                if (cw==1){
                    System.out.println("您的仓位有食物供应，但不可以播放电影");
                }else{
                    if (time == 1) {
                        System.out.println("您的仓位没有食物供应，且不可以播放电影");
                    }else {
                        System.out.println("您的仓位有食物供应，但不可以播放电影");
                    }
                }
            }
            System.out.println("是否继续测试?如果退出请输入0,继续输入1");
            flag = sc.nextInt();
        }
    }
}