package homework6.qiankelong;


public class Client
{
    public static void main(String a[])
    {

        Vector vector,copyVector;
        vector=new Vector();
        int[] arr= {2,8,3,6};
        vector.setArray(arr);
        System.out.println("浅克隆示例：");
        copyVector=(Vector)vector.clone();
        System.out.print("vector：");
        vector.display();
        System.out.print("copyVector：");
        copyVector.display();
        System.out.println("vector==copyVector?");
        System.out.println(vector==copyVector);

        System.out.println("vector.getAttachment==copyVector.getAttachment?");
        System.out.println(vector.getAttachment()==copyVector.getAttachment());
    }
}