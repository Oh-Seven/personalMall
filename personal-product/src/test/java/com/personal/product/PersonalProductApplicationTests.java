package com.personal.product;

import com.personal.product.entity.PmsBrandEntity;
import com.personal.product.service.PmsBrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonalProductApplicationTests {

    @Autowired
    PmsBrandService pmsBrandService;

    @Test
    public void contextLoads() {
        PmsBrandEntity entity = new PmsBrandEntity();
        entity.setDescript("xxx");
        entity.setName("测试");
        pmsBrandService.save(entity);
    }

}
