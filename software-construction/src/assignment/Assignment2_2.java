package assignment;

import java.util.Random;
import java.util.Scanner;

public class Assignment2_2 {

    //题目类
   static class  Equation{
       int  left_operand = 0, right_operand = 0 ;
       char operator = ' ';
       int value = 0;
       int v ;    //自己做出的结果


       public Equation(int left_operand, int right_operand, char operator, int value) {
           this.left_operand = left_operand;
           this.right_operand = right_operand;
           this.operator = operator;
           this.value = 0;
       }


   }

    static Equation [] equation = new Equation[50];
    static Random random = new Random();
    static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) {
        printHeader();
        generateEquations();
        printExercise();
        printCalculations();
    }

    //打印程序作用
    private static void printHeader() {
        System.out.println("--------------------------------------");
        System.out.println("- 程序输出50道100以内的加法减法算式的习题 -");
        System.out.println("- 每次运行程序可得到一套50道题的习题及答案 -");
        System.out.println("--------------------------------------");

    }

    //生成习题
    private static void generateEquations() {
        char operator = ' ';
        equation[0] = new Equation(-1,-1,' ',-1);//初始化【0】

        for (int i = 0; i < 50; i++) {

            int left_operand = random.nextInt(100);
            int right_operand = random.nextInt(100);
            int o = random.nextInt(2);
            if (o==0){
                 operator = '+';
            }else if (o == 1){
                 operator = '-';
            }else{
                System.out.println("运算符错误");
                System.exit(0);
            }
            Equation e = new Equation(left_operand,right_operand,operator,0);

            equation[i]=e;
            if (!check(e,equation,i)) {
                equation[i]=e;
                check(e,equation,i);
            }
            if (equation[i].operator=='+'){
                equation[i].value = equation[i].left_operand+equation[i].right_operand;
            }else if (equation[i].operator=='-'){
                equation[i].value = equation[i].left_operand-equation[i].right_operand;
            }else {
                System.out.println("运算符错误");
                System.exit(0);
            }
        }


    }
    //打印练习题
    private static void printExercise() {
        System.out.println("**************************************");
        System.out.println("运算题如下：");
        System.out.println("**************************************");
        for (int i = 0; i < 50; i++) {
            if(i%7==0) System.out.println();

            if (equation[i].operator=='+'){
                System.out.print("第" + (i+1) + "题："+equation[i].left_operand+"+"+equation[i].right_operand+"="+"              ");
            }else if (equation[i].operator=='-'){
                System.out.print("第" + (i+1) + "题："+equation[i].left_operand+"-"+equation[i].right_operand+"="+"              ");
            }else {
                System.out.println("运算符错误");
                System.exit(0);
            }
        }
        System.out.println();
    }
    //打印答案
    private static void printCalculations() {
        System.out.println("**************************************");
        System.out.println("答案如下：");
        System.out.println("**************************************");

        for (int i = 0; i < 50; i++) {
            if(i%7==0) System.out.println();
                System.out.print("第" + (i+1) + "题："+equation[i].value+"              ");
        }

    }

    //检查重复题目
    private static  Boolean check(Equation e,Equation [] equation,int j){     //去除重复的
        for (int i = 0; i < j-1 ; i++) {
            if (e.value==equation[i].value){
                if(e.operator == equation[i].operator){
                    if(e.right_operand ==equation[i].right_operand) {
//                        System.out.println("已排除重复");
                        return  false;}
                }
            }
        }
            return true;

    }


}
