package com.zy.grpc.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zy.grpc.server.server.ABean;
import com.zy.grpc.server.server.BBean;
import com.zy.grpc.server.server.GrpcServer;

@Configuration
public class GrpcServerConfig {
	
	@Bean
	public GrpcServer grpcServer() throws Exception {
		GrpcServer grpcServer = new GrpcServer(50011);
		grpcServer.start();
		return grpcServer;
	}
	
	@Bean
	public BBean bBean(@Autowired(required = false) ABean aBean){
		BBean bBean = new BBean();
		bBean.setaBean(aBean);
		bBean.setbName("BBB");
		return bBean;
	}

}
