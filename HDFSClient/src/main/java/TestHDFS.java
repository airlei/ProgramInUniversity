
import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;

public class TestHDFS {
    public static FileSystem fs = null;

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();
        System.setProperty("HADOOP_USER_NAME", "root");
        conf.set("fs.defaultFS", "hdfs://hadoop102:8020");
        fs = FileSystem.get(conf);
        if(!fs.exists(new Path("/zl"))){
            fs.create(new Path("/zl"));
        }

        create();

        copy();

        fs.close();
    }
    public static void create() throws Exception {
        if(!fs.exists(new Path("/test/hdfstest1.txt"))){
            System.out.println("hdfstest1不存在");
            FSDataOutputStream output = fs.create(new Path("/test/hdfstest1.txt"));
            output.write("20204103-赵磊-HDFS课堂测试".getBytes());
            output.flush();
            output.close();
        }
        else{
            System.out.println("hdfstest1存在！");
        }
    }

    public static void copy() throws Exception {
        FSDataInputStream fin = fs.open(new Path("/test/hdfstest1.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(fin, "UTF-8"));
        if(!fs.exists(new Path("/test/hdfstest2.txt"))){
            System.out.println("正在创建hdfstest2文件");
            FSDataOutputStream fout  = fs.create(new Path("/test/hdfstest2.txt"));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fout, "UTF-8"));
            out.write(in.readLine());
            out.flush();
            out.close();
        }else{
            System.out.println("hdfstest2文件已存在");
        }

    }



}