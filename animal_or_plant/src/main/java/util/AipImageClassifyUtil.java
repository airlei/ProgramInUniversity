package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;


public class AipImageClassifyUtil {
    //设置APPID/AK/SK
    public static final String APP_ID = "28090873";
    public static final String API_KEY = "FPSnWgXK2sbbyy3my1IncIYK";
    public static final String SECRET_KEY = "sryr1ZvTF9QHMYCD4o646Xmm9X4Bk0UK";
    public static String path = "D:\\6.jpg";   //初始化随便选一个路径
    public static AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);


    public static void main(String[] args) {
        sample(client,path);
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


        return res.toString();

    }





}
