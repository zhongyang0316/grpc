package com.zy.grpc.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zy.grpc.client.client.GrpcClient;

@Configuration
public class GrpcClientConfig {
	
	@Bean
	public GrpcClient grpcClient() {
		GrpcClient client = new GrpcClient("127.0.0.1", 50011);
		return client;
	}

}
