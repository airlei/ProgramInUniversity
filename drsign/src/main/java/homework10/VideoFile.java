package homework10;

public class VideoFile extends AbstractFile{

    private String filename;

    public VideoFile(String f) {
        filename=f;
    }
    @Override
    public void add(AbstractFile ele) {
        System.out.println("添加Video文件");
    }

    @Override
    public void remove(AbstractFile ele) {
        System.out.println("删除Video文件");
    }

    @Override
    public void display() {
        System.out.println("展示Video文件"+filename);
    }

}