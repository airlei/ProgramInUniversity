package assignment;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
public class lainxi {

    public static void main(String [] args) {
        System.out.println("请输入需要打印的题目数量！！！！");
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++) {
            if(i%6==0)
                System.out.println();
            System.out.print(jisuan()+"="+"       ");
        }


    }
    public static String jisuan() {
        Random random = new Random();
        int []a=new int[3];
        int w;
        String q="";
        for(int i=0;i<3;i++) {
            a[i]=random.nextInt(100)+1;
            q+=a[i];
            if(i==2)
                break;
            w=random.nextInt(10);
            if(w%2==1) {
                q+="+";
            }else {
                q+="-";
            }
        }
        return q;
    }
}
