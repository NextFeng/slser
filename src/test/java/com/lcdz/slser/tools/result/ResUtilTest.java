package com.lcdz.slser.tools.result;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author QinZhenGuo
 * @date 2019/12/3 13:54
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ResUtilTest {

    @Test
    public void success() {
        List<Map<String,String>> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Map<String,String> map = new HashMap<>();
            map.put("张三" + i ,"Age" + i);
            map.put("李四" + i ,"Age" + i);
            map.put("王五" + i ,"Age" + i);
            list.add(map);
        }

        log.info("【返回值是】" + ResUtil.success(list));
    }

    @Test
    public void error() {
    }
}