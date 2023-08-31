
 package homework6.qiankelong;

        import java.util.Arrays;

         public class Vector implements Cloneable
 {
             private int[] array;

             private Attachment attachment=null;

             public Vector()
             {

                 this.attachment=new Attachment();
             }

             public Object clone()
             {
                 Vector clone=null;
                 try
                 {
                     clone=(Vector)super.clone();
                 }
                 catch(CloneNotSupportedException e)
                 {
                     System.out.println("Clone failure!");
                 }
                 return clone;
             }

             public Attachment getAttachment()
             {
                 return this.attachment;
             }

             public void display()
             {
                     System.out.println(Arrays.toString(array));
             }

             public int[] getArray() {
                 return array;
             }

             public void setArray(int[] array) {
                 this.array = array;
             }

         }