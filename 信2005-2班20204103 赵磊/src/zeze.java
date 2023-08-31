package zeze;
import java.util.*;

public class zeze {
    static Scanner sc = new Scanner (System.in);
    public static void main(String[] args) {//主方法
        Student [] student=new Student[3];
        student[0]=new Student();
        student[1]=new Student();
        student[2]=new Student();
        information(student);
        int flag=0;
        for(;flag!=0;) {
            menu();
            int choice = sc.nextInt();
            choice(choice,student,flag);
        }
    }

    static public void menu() {
        System.out.println("************************************");
        System.out.println("1 获取姓名");
        System.out.println("2 修改姓名");
        System.out.println("3 输入成绩");
        System.out.println("4 读取成绩");
        System.out.println("5 获取平均成绩");
        System.out.println("6 退出");
        System.out.println("请选择：");
        System.out.println("************************************");
    }
    static public void choice(int choice,Student [] student,int flag) {
        switch(choice) {
            case 1:get_name(student);
                break;
            case 2:rename(student);
                break;
            case 3:set_score(student);
                break;
            case 4:get_score(student);
                break;
            case 5:get_score_average(student) ;
                break;
            case 6:flag=1;
                System.out.println("已退出");
                break;
            default:
                break;
        }
    }
    static public void information(Student [] student) {
        student[0].name="张三";
        student[1].name="李四";
        student[2].name="王五";
        student[0].set_num(01);
        student[1].set_num(02);
        student[2].set_num(03);

    }
    static public int get_name(Student [] student) {
        System.out.println("请输入要获得姓名学生的学号");
        int num=sc.nextInt();
        for(int i=0;i<3;i++) {
            if(student[i].get_num()==num) {
                System.out.println(student[i].name);
                return 0;
            }}
        System.out.println("未查询到该学号");
        return 0;
    };
    static public int rename(Student [] student) {
        System.out.println("请输入要修改姓名学生的学号");
        int num=sc.nextInt();

        for(int i=0;i<3;i++) {
            if(student[i].get_num()==num) {
                System.out.println("要修改的学生名字是："+student[i].name);
                System.out.println("请输入修改后的名字");
                String name=sc.nextLine();
                student[i].name=name;
                return 0;
            }}
        System.out.println("未查询到该学号");
        return 0;

    };
    static public void set_score(Student [] student) {

        System.out.println("请按照语文，数学，英语的顺序输入成绩");
        for(int i=0;i<3;i++) {
            System.out.println("请输入" + student[i].name +"的成绩");
            student[i].score_Chinese=sc.nextDouble();
            student[i].score_Math=sc.nextDouble();
            student[i].score_English=sc.nextDouble();
        }

    };
    static public int get_score(Student [] student) {
        System.out.println("请输入要读取成绩的学生的学号");
        int num=sc.nextInt();
        for(int i=0;i<3;i++) {
            if(student[i].get_num()==num) {
                System.out.println("该学生语文成绩："+student[i].score_Chinese);
                System.out.println("该学生数学成绩："+student[i].score_Math);
                System.out.println("该学生英语成绩："+student[i].score_English);
                return 0;
            }}
        System.out.println("未查询到该学号");
        return 0;


    };
    static public int get_score_average(Student [] student) {

        for(int i=0;i<3;i++) {
            student[i].score_average=student[i].score_Chinese + student[i].score_Math+student[i].score_English;
            student[i].score_average=student[i].score_average/3;
        }
        System.out.println("请输入要获得平均分学生的学号");
        int num=sc.nextInt();
        for(int i=0;i<3;i++) {
            if(student[i].get_num()==num) {
                System.out.println(student[i].score_average);
                return 0;
            }}
        System.out.println("未查询到该学号");
        return 0;
    };


}



class Student {
    public String name ;//姓名
    private int num ;//学号
    private int class_num = 4; //课程数
    public double score_Chinese = 0.0;//语文成绩
    public double score_Math = 0.0;//数学成绩
    public double score_English = 0.0;//英语成绩
    public double score_average = 0.0;//平均数
    public int get_num() {
        return this.num;
    }
    public void set_num (int num) {this.num=num;}


}