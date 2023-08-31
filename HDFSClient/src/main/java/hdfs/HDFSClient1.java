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


public class HDFSClient1 {


    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        mkdir();
        addFile();
        copyFile();

    }



    public static void mkdir() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(new URI("hdfs://hadoop102:8020"), conf, "zzx");

        Path dir = new Path("/zl");
        hdfs.mkdirs(dir);

        hdfs.close();
    }
    public static void addFile() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(new URI("hdfs://hadoop102:8020"), conf, "zzx");

        Path inFile = new Path("/zl/hdfstest1.txt");
        FSDataOutputStream outputStream = hdfs.create(inFile);
        outputStream.writeUTF("信2005-2班-20204103-赵磊-HDFS课堂测试");
        outputStream.flush();
        outputStream.close();

        hdfs.close();
    }
    public static void copyFile() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(new URI("hdfs://hadoop102:8020"), conf, "zzx");

        Path inFile = new Path("/zl/hdfstest1.txt");
        Path newFile = new Path("/zl/hdfstest2.txt");
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
