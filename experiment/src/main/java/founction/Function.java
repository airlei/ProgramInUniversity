package founction;

import java.util.*;
import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;

import java.util.HashMap;


/**
 * 图像识别sdk
 */
public class Function {
    //设置APPID/AK/SK
    public static final String APP_ID = "28172969";
    public static final String API_KEY = "4eReYrQtAh9YN6QFuWGyuqlu";
    public static final String SECRET_KEY = "Y3tTclcDqxZP3ZLBLUISPEHDIzRUlBcx";
    public static String path = "D:\\6.jpg";   //初始化随便选一个路径
    // 初始化一个AipOcr
    public static AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);


    public static void main(String[] args) {
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        System.out.println("身份证***********************************");
        idCard("D://1.jpg");

        System.out.println("车牌***********************************");
        licensePlate("D://2.jpg");

    }



    public static String idCard(String path) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");

        String idCardSide = "back";

        // 参数为本地图片路径
//        String image = "";
        JSONObject res = client.idcard(path, idCardSide, options);
        System.out.println(res.toString(2));
        return res.toString(2);
    }



    public static String licensePlate( String path) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("multi_detect", "true");


        // 参数为本地图片路径
//        String image = "D://2.jpg";
        JSONObject res = client.plateLicense(path, options);

        System.out.println(res.toString(2));
        return res.toString(2);

    }



}
