package com.plateer.ec1.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    void test(){testMapper.selectTest();}
}
