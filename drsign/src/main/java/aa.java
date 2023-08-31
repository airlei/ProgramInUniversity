import java.util.Scanner;

public class aa4 {

    public static void main(String[] args) {
        System.out.println("请输入矩阵阶数：");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();// 行数
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        array[i][k] = array[i][k] | array[j][k];
                    }
                }
            }
        }
        System.out.println("传递闭包的最终结果是：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

}