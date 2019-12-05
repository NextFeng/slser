package com.lcdz.slser.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/3 11:58
 */

@Slf4j
public class ParamUtil {

    private static final String key = "lcdz7758521";


    /**
     * 签名算法，区别为获取前民秘钥
     *
     * @param map 要参与签名的数据对象以及签名秘钥
     * @return 签名
     * @throws IllegalAccessException
     */
    public static String getSign(Map<String, String> map) throws Exception{
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().length() != 0 && entry.getValue() != null) {
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + key;
        result = MD5(result).toUpperCase();
        return result;
    }

    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 生成 HMACSHA256
     *
     * @param data 待处理数据
     * @param key  密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String HMACSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }



    /**
     * 检验签名是否合法，避免数据在传输的过程中被第三方篡改
     * @param map 获取到的参数集合
     * @return API签名是否合法
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static boolean checkSgin(Map<String, String> map) throws Exception {
        String signFromAPIResponse = map.get("sign");
        if (signFromAPIResponse == "" || signFromAPIResponse == null) {
            return false;
        }
        map.remove("sign");
        String signForAPIResponse = getSign(map);
        if (!signForAPIResponse.equals(signFromAPIResponse)) {
            return false;
        }
        return true;
    }

}
