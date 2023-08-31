import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class MainClass {
    public static void main(String[] args) throws IOException {
        Configuration conf=new Configuration();
        conf.set("fs.default.name", "hdfs://hadoop102:8020");
        Path inFile =new Path("zl/hdfstest1.txt");
        FileSystem hdfs=FileSystem.get(conf);
        FSDataOutputStream outputStream=hdfs.create(inFile);
        outputStream.writeUTF("信2005-2班20204103赵磊HDFS课堂测试");
        outputStream.flush();
        outputStream.close();
    }
}
