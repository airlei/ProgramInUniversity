package homewoek18;

public class Student  implements Comparable<Student>{
    private int studentid;
    private String name;
    private int age;
    private String major;

    public Student(int studentid, String name, int age, String major) {
        super();
        this.studentid = studentid;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    // 三个返回结果都要写出来
    public int compareTo(Student o) {
        if(this.studentid > o.studentid){
            return -1;
        }else if(this.studentid < o.studentid){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString(){
        return "姓名: " + this.name + ". 学号: " + this.studentid + ". 年龄: " + this.age
                + ". 专业: " + this.major;
    }
}
