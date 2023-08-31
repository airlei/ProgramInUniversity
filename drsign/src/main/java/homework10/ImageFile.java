package homework10;

public class ImageFile extends AbstractFile{

    private String filename;

    public ImageFile(String f) {
        filename=f;
    }
    @Override
    public void add(AbstractFile ele) {
        System.out.println("添加Image文件");
    }

    @Override
    public void remove(AbstractFile ele) {
        System.out.println("删除Image文件");
    }

    @Override
    public void display() {
        System.out.println("展示Image文件"+filename);
    }

}