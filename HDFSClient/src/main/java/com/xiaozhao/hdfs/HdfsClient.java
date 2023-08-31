package com.xiaozhao.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.security.auth.login.AppConfigurationEntry;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class HdfsClient {
    private FileSystem fs;
    @Before
    public void init() throws URISyntaxException, IOException, InterruptedException {
        //连接集群的nn地址
        URI uri = new URI("hdfs://hadoop102:8020");
        //创建一个配置文件
        Configuration configuration = new Configuration();
        //用户
        String user = "zzx";
        //获取到了客户端对象
        fs = FileSystem.get(uri, configuration,user);
    }
    @After
    public void close() throws IOException {
        //关闭资源
        fs.close();
    }

    //创建目录
    @Test
    public void testmkdir() throws URISyntaxException, IOException, InterruptedException {
        //执行相关操作--创建一个文件夹
        fs.mkdirs(new Path("/zl/As.txt"));
    }
    @Test
    //上传
    public void testPut() throws IOException {
        //参数1：表示删除原数据   参数二：是否允许覆盖  参数三：原数据路径   参数四：目的地路径
        fs.copyFromLocalFile(false,false,
                new Path("D:\\sunwukong.txt"),new Path("/xiyou/huaguoshan"));
    }

    @Test
   //文件下载
    public void testGet() throws IOException {
        //参数：原文件是否删除  参数2:原文件路径HDFS  参数3：目标地址路径win  参数4是否开启本地校验
        fs.copyToLocalFile(false,new Path("hdfs://hadoop102/xiyou/huaguoshan"),
                new Path("D:\\"),true);

    }

    @Test
    //删除
    public void testRm() throws IOException {

        //参数1: 要删除的路径 参数2：是否递归参数
        //文件删除
        fs.delete(new Path("/xiyou/s.txt"),false);
        //删除空目录
        fs.delete(new Path("/xiyou"),false);
        //删除非空目录
        fs.delete(new Path("/jinguo"),true);
    }


    @Test
    //文件的更名和移动

    public void testmv() throws IOException {

        //参数1： 原文件路径   参数2：目标文件路径
        //对文件名称的修改
        fs.rename(new Path("/wcinput/word.txt"),new Path("/wcinput/ss.txt"));
        //文件的移动和更名
        fs.rename(new Path("/wcinput//ss.txt"),new Path("/cls.txt"));
        //目录的更名
        fs.rename(new Path("/wcinput"),new Path("/input"));
    }


    @Test
    //获取文件详细信息
    public void fileDetail() throws IOException {

        //参数1：查看的路径  参数2：递归
        //获取所有文件信息。迭代器
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
        //遍历文件
        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next();

            System.out.println("---------------"+fileStatus.getPath()+"------------");//路径
            System.out.println(fileStatus.getPermission());//权限
            System.out.println(fileStatus.getOwner());//所属用户
            System.out.println(fileStatus.getGroup());//所属组
            System.out.println(fileStatus.getLen());//大小
            System.out.println(fileStatus.getModificationTime());//上次修改时间
            System.out.println(fileStatus.getReplication());//副本
            System.out.println(fileStatus.getBlockSize());//块大小
            System.out.println(fileStatus.getPath().getName());//名称

            //获取块信息
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            System.out.println(Arrays.toString(blockLocations));
        }
    }

    @Test
    //判断是文件夹还是文件
    public void testFile() throws IOException {

        FileStatus[] listStatus = fs.listStatus(new Path("/"));

        for (FileStatus status : listStatus) {
            if (status.isFile()) {
                System.out.println("这是一个文件:"+status.getPath().getName());
            }else {
                System.out.println("这是一个目录:"+status.getPath().getName());

            }
        }

    }
}
