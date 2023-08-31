package homework10;
import java.util.ArrayList;

public class Folder extends AbstractFile{

    private String filename;
    private ArrayList al=new ArrayList<>();


    public Folder(String f) {
        filename=f;
    }
    @Override
    public void add(AbstractFile ele) {
        al.add(ele);
        System.out.println("已增加文件");
    }

    @Override
    public void remove(AbstractFile ele) {

        al.remove(ele);
        System.out.println("删除文件");
    }

    @Override
    public void display() {
        for(Object object:al)
        {
            ((AbstractFile)object).display();
        }
        System.out.println("展示目录");

    }

}