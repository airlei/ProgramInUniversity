package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baidu.aip.imageclassify.*;
import org.json.JSONObject;
import com.baidu.aip.util.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.baidu.aip.util.Util.readFileByBytes;


/**
 * 图像识别sdk
 */
public class AipImageClassifyUtil {
    //设置APPID/AK/SK
    public static final String APP_ID = "28090873";
    public static final String API_KEY = "FPSnWgXK2sbbyy3my1IncIYK";
    public static final String SECRET_KEY = "sryr1ZvTF9QHMYCD4o646Xmm9X4Bk0UK";
    public static String path = "D:\\6.jpg";   //初始化随便选一个路径
    public static AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);


    public static void main(String[] args) {
        sampleAnimal(client);
    }

    public static String sample(AipImageClassify client,String path) {

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
//        options.put("top_num", "3");
//        options.put("baike_num", "0");
        options.put("with_face", "0");


//        JSONObject res = null;
        JSONObject res = client.advancedGeneral(path, options);
        System.out.println(res.toString(2));
        System.out.println("********************");

//        System.out.println(res.get(String.valueOf("root")));
//        System.out.println(res.getJSONArray("root").get(0));
        JSONArray array = JSON.parseArray(String.valueOf(res));
        for ( int i = 0; i <array.size() ; i++) {
            array.getJSONObject(1);
            System.out.println("************************************************");

        }
        return res.toString();

    }


    public static void sampleAnimal(AipImageClassify client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "3");
        options.put("baike_num", "5");


        // 参数为本地路径
        String image = "D://1.png";
        JSONObject res = client.animalDetect(image, options);
        System.out.println(res.toString(2));

//        // 参数为二进制数组
//        byte[] file = readFile("test.jpg");
//        res = client.animalDetect(file, options);
//        System.out.println(res.toString(2));
    }



}
