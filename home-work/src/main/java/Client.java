import java.util.Scanner;

public class Client {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        DES des = new DES();
        IDEA idea = new IDEA();
        try {
            int n = 0;

            Scanner in = new Scanner(System.in);
            while (n != 3) {
                System.out.println("请选择要使用的加密算法 1.DES加密算法 2.IDEA加密算法 3.退出");
                System.out.println("请选择：");
                if (in.hasNextInt()) {
                    n = in.nextInt();
                } else {
                    System.out.println("输入的不是整数，请重新输入：");
                    continue;
                }
                switch (n) {
                    case 1: {
                        System.out.println("请输入要加密的数据");
                        String data = sc.nextLine();

                        des.encrypt(data,"1787878787878787", "0E329232EA6D0D73");
                        break;
                    }
                    case 2: {
                        System.out.println("请输入要加密的数据");
                        String data = sc.nextLine();
                        idea.encrypt(data,"8787878787878787", "0E329232EA6D0D73");
                        break;
                    }
                }
            }
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}