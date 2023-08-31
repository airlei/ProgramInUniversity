package homework6.shenkelong;
public class Client
{
    public static void main(String a[])
    {
        Vector vector,copyVector=null;

        vector=new Vector();
        int[] arr= {2,8,3,6};
        vector.setArray(arr);
        System.out.println("深克隆示例：");

        try{
            copyVector=(Vector)vector.deepClone();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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
