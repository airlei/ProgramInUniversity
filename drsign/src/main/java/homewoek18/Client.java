package homewoek18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student(20204103, "赵磊", 20, "软件工程专业");
        Student s2 = new Student(20204104, "李四", 20, "材料专业");
        Student s3 = new Student(20204105, "王五", 20, "机械专业");
        Student s4 = new Student(20204106, "赵六", 20, "工商管理专业");
        Student s5 = new Student(20204107, "张三", 20, "土木专业");
        Student s6 = new Student(20204108, "孙七", 20, "电气专业");

        Student2 s7 = new Student2(20204103, "赵磊", 20, "软件工程专业");
        Student2 s8 = new Student2(20204104, "李四", 20, "材料专业");
        Student2 s9 = new Student2(20204105, "王五", 20, "机械专业");
        Student2 s10 = new Student2(20204106, "赵六", 20, "工商管理专业");
        Student2 s11 = new Student2(20204107, "张三", 20, "土木专业");
        Student2 s12 = new Student2(20204108, "孙七", 20, "电气专业");
        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        Collections.sort(list);
        System.out.println("按照学号从大到小输出: ");
        for(Student stu : list){
            System.out.println(stu.toString());
        }
        System.out.println("-----------------------------------------------------------------");
        List<Student2> list2 = new ArrayList<Student2>();
        list2.add(s7);
        list2.add(s8);
        list2.add(s9);
        list2.add(s10);
        list2.add(s11);
        list2.add(s12);
        Collections.sort(list2);
        System.out.println("按照学号从小到大输出: ");
        for(Student2 stu : list2){
            System.out.println(stu.toString());
        }
    }
}
