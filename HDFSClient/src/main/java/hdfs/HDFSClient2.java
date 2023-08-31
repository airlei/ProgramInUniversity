package hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;


/**
 * hadoop 的增删改查,新建的话是不加/，就在相对路径/user下创建文件
 */
public class HDFSClient2 {


    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            showWindow();
            int idx = scanner.nextInt();
            if(idx==1){
                System.out.println("输入文件名：");
                String str = scanner.next();
                mkFile(str);
                System.out.println("创建成功！！");
            }else if(idx==2){
                System.out.println("输入文件名：");
                String str = scanner.next();
                System.out.println("文件内容：");
                showFile(str);
            }else if(idx==3){
                System.out.println("输入文件名：");
                String str = scanner.next();
                System.out.println("输入添加内容：");
                String data = scanner.next();
                addData(str,data);
                System.out.println("添加成功");
            }else if(idx==4){
                System.out.println("输入源文件：");
                String str = scanner.next();
                System.out.println("输入目标文件：");
                String str2 = scanner.next();
                copyFile(str,str2);
                System.out.println("备份成功！！");
            }else{
                break;
            }

        }
    }

    private static void showWindow() {
        System.out.println();
        System.out.println();
        System.out.println("**************************************************************************");

        System.out.println("1.新建      2.打开      3.添加内容      4.另存      5.退出 ");
        System.out.println("**************************************************************************");
        System.out.println("请执行操作：");
    }

    public static void copyFile(String source, String to) throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(new URI("hdfs://hadoop102:8020"), conf, "zzx");

        Path inFile = new Path(source);
        Path newFile = new Path(to);
        FSDataInputStream inputStream = hdfs.open(inFile);
        FSDataOutputStream outputStream = hdfs.create(newFile);

        String str = inputStream.readUTF();
        inputStream.close();

        outputStream.writeUTF(str);
        outputStream.flush();
        outputStream.close();

        hdfs.close();
    }

    public static void showFile(String path) throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(new URI("hdfs://hadoop102:8020"), conf, "zzx");

        Path inFile = new Path(path);
        FSDataInputStream inputStream = hdfs.open(inFile);

        String str = inputStream.readUTF();
        inputStream.close();
        System.out.println(str);

        hdfs.close();
    }

    public static void mkFile(String path) throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(new URI("hdfs://hadoop102:8020"), conf, "zzx");

        Path inFile = new Path(path);
        System.out.println(inFile);
        hdfs.create(inFile);

        hdfs.close();
    }
    public static void addData(String path, String data) throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(new URI("hdfs://hadoop102:8020"), conf, "zzx");

        Path inFile = new Path(path);

        FSDataOutputStream outputStream = hdfs.append(inFile);

        outputStream.writeUTF(data);
        outputStream.flush();
        outputStream.close();

        hdfs.close();
    }




















    public void mkdir() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(new URI("hdfs://hadoop102:8020"), conf, "zzx");

        Path dir = new Path("/zzx");
        hdfs.mkdirs(dir);

        hdfs.close();
    }


    public void addFile() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(new URI("hdfs://hadoop102:8020"), conf, "zzx");

        Path inFile = new Path("/zzx/hdfstest1.txt");
        FSDataOutputStream outputStream = hdfs.create(inFile);
        outputStream.writeUTF("信2005-1班20204102赵磊HDFS课堂测试");
        outputStream.flush();
        outputStream.close();

        hdfs.close();
    }
    public void copyFile() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(new URI("hdfs://hadoop102:8020"), conf, "zzx");

        Path inFile = new Path("/zzx/hdfstest1.txt");
        Path newFile = new Path("/zzx/hdfstest2.txt");
        FSDataInputStream inputStream = hdfs.open(inFile);
        FSDataOutputStream outputStream = hdfs.create(newFile);

        String str = inputStream.readUTF();
        inputStream.close();

        outputStream.writeUTF(str);
        outputStream.flush();
        outputStream.close();

        inputStream = hdfs.open(newFile);
        System.out.println(inputStream.readUTF());
        inputStream.close();

        hdfs.close();
    }


}
