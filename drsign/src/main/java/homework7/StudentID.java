package homework7;

public class StudentID {

    private static StudentID instance=null;

    private String ID;



    public String getID() {

        return ID;

    }



    public void setID(String iD) {

        ID = iD;

    }



    private StudentID()

    {



    }



    public static StudentID getStudentID()

    {

        if(instance==null) {

            instance=new StudentID();

            instance.setID("20194080");

        }

        else

        {

            System.out.println("一个学生只能有一个学号");

        }

        return instance;

    }

}
