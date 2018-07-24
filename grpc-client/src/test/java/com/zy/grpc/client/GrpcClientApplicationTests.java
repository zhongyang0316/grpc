package com.zy.grpc.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zy.grpc.client.client.GrpcClient;
import com.zy.grpc.common.protobuf.PersonProbuf.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrpcClientApplicationTests {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private GrpcClient grpcClient;
	
	@Test
	public void contextLoads() {
		this.logger.info("只是测试。。。。");
		//发送消息测试
		Person person1 = this.grpcClient.query("ZY1");
		this.logger.info("person1:{}", person1);
		
		Person person2 = this.grpcClient.query("ZY2");
		this.logger.info("person2:{}", person2);
		
		this.logger.info("测试结束。。。。");
	}

}
