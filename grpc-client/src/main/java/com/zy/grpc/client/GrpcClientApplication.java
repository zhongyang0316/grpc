package com.zy.grpc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.zy.grpc.client"})
public class GrpcClientApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GrpcClientApplication.class, args);
		System.out.println(ctx.getId() + " started!");
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GrpcClientApplication.class);
	}

}
