package com.lcdz.slser.tools.result;


import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResUtil {


    public static String success(List<Map<String,String>> list){
        Map<String,String> map = new HashMap<>();
        map.put("ReturnCode","SUCCESS");
        map.put("ReturnMsg","OK");
        map.put("data",new Gson().toJson(list));
        return maptoXML(map);
    }

    public static String success(Map<String,String> map,List<Map<String,String>> list){
        map.put("ReturnCode","SUCCESS");
        map.put("ReturnMsg","OK");
        map.put("data",new Gson().toJson(list));
        return maptoXML(map);
    }

    public static String success(Map<String,String> map){
        map.put("ReturnCode","SUCCESS");
        map.put("ReturnMsg","OK");
        return maptoXML(map);
    }

    public static String error(String msg){
        Map<String,String> map = new HashMap<>();
        map.put("ReturnCode","FAIL");
        map.put("ReturnMsg",msg);
        return maptoXML(map);
    }


    /**
     * 转换Map至String
     */
    public static String maptoXML(Map map) {
        Set<String> keys = map.keySet();
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        for (String key : keys) {
            sb.append("<" + key + ">");
            sb.append(map.get(key) == null ? "" : map.get(key));
            sb.append("</" + key + ">");
        }
        sb.append("</xml>");
        return sb.toString();
    }


}
