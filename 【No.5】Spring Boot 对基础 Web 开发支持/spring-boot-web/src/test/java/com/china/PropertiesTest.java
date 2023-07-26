package com.china;

import com.china.common.DevProperties;
import com.china.common.OtherProperties;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PropertiesTest {

    @Value("${dev.title}")
    private String title;

    @Resource
    private DevProperties properties;

    @Resource
    private OtherProperties otherProperties;

    @Test
    public void testSingle() {
        Assertions.assertEquals("配置信息",title);
    }

    @Test
    public void testMore() throws Exception {
        System.out.println("title:"+properties.getTitle());
        System.out.println("description:"+properties.getDescription());
    }

    @Test
    public void testOther() throws Exception {
        System.out.println("title:"+otherProperties.getTitle());
        System.out.println("description:"+otherProperties.getDescription());
    }
}
