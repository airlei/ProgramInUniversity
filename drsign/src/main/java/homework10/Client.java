package homework10;
public class Client {
    public static void main(String a[])
    {
        AbstractFile obj1,obj2,obj3,obj4,obj5;
        Folder plate1,plate2,plate3;
        obj1=new ImageFile("a.png");
        obj2=new TextFile("b.png");
        plate1=new Folder("c");
        plate1.add(obj1);
        plate1.add(obj2);

        obj3=new VideoFile("d.mp3");
        obj4=new VideoFile("e.mp3");
        plate2=new Folder("f");
        plate2.add(obj3);
        plate2.add(obj4);

        obj5=new ImageFile("g.jpg");
        plate3=new Folder("h");
        plate3.add(plate1);
        plate3.add(plate2);
        plate3.add(obj5);

        plate3.display();
        plate3.remove(obj5);

    }
}