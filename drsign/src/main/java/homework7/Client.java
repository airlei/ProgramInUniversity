package homework7;

public class Client {

    public static void main(String[] args) {

        StudentID stu1,stu2;

        stu1=StudentID.getStudentID();

        stu2=StudentID.getStudentID();

        String str1,str2;

        str1=stu1.getID();

        str2=stu2.getID();

        System.out.println("第一次学号："+str1);

        System.out.println("第二次学号："+str2);

    }

}