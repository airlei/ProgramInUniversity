



import java.io.IOException;
import java.net.InetAddress;


public class ceshi {

    public static void main(String[] args) throws IOException {
        //获取IP地址
//        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String hostAddress = "59.71.244.28";
        //工具类
//        System.out.println(IPUtil.getCityInfo(hostAddress));
        String detail = IPUtil.getCityInfo(hostAddress);
        String provide = detail.split("\\|")[2];
        String city = detail.split("\\|")[3];

        System.out.println("IP地址:"+hostAddress+"地区:"+detail);
        System.out.println("省份为："+provide);
        System.out.println("城市为:" + city);
    }
}