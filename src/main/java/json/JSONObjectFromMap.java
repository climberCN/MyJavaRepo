package json;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JSONObjectFromMap {
    public static void main(String[] args) {
        jsonFromMap();
    }

    public static void jsonFromMap() {
        Map<String, Object> wangxiaoer = new HashMap<String, Object>();
        wangxiaoer.put("name","王小二");
        wangxiaoer.put("age", 25.2);
        wangxiaoer.put("school", "蓝翔");
        wangxiaoer.put("major", new String[]{"理发","挖掘机"});
        wangxiaoer.put("has_girlfriend", false);
        wangxiaoer.put("car", null);
        wangxiaoer.put("house", null);
        wangxiaoer.put("comment", "这是一个注释");
        JSONObject jsonObject = new JSONObject(wangxiaoer);
        System.out.println(jsonObject.toString());
    }
}