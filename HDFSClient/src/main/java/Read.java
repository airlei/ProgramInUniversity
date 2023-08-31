import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Read {
    public static void main(String[] args) throws IOException {
        Configuration conf=new Configuration();
        conf.set("fs.default.name", "hdfs://hadoop102:8020");
        Path inFile =new Path("/zl/hdfstest1.txt");
        Path newFile =new Path("/zl/hdfstest2.txt");


        FileSystem hdfs=FileSystem.get(conf);
        FSDataOutputStream outputStream=hdfs.create(newFile);

        FSDataInputStream inputStream=hdfs.open(inFile);
        String str = inputStream.readUTF();
        inputStream.close();

        outputStream.writeUTF(str);
        outputStream.flush();
        outputStream.close();

        inputStream=hdfs.open(newFile);
        System.out.println(inputStream.readUTF());
    }
}