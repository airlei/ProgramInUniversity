package homework10;
public class TextFile extends AbstractFile{

    private String filename;

    public TextFile(String f) {
        filename=f;
    }
    @Override
    public void add(AbstractFile ele) {
        System.out.println("添加Text文件");
    }

    @Override
    public void remove(AbstractFile ele) {
        System.out.println("删除Text文件");
    }

    @Override
    public void display() {
        System.out.println("展示Text文件"+filename);
    }

}