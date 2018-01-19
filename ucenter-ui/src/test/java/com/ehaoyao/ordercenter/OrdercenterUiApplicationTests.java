package com.ehaoyao.ordercenter;

import com.ehaoyao.ordercenter.web.orders.service.BigCustomerBasicInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdercenterUiApplicationTests {

	@Autowired
	BigCustomerBasicInfoService bigCustomerBasicInfoService;

	@Test
	public void contextLoads() {

		System.out.println
				("【单个查询--->查询结果】："+bigCustomerBasicInfoService
				.getById ( 4 ) );
	}

}
