package com.zy.grpc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.zy.grpc.server.server.BBean;
import com.zy.grpc.server.server.GrpcServer;

@SpringBootApplication(scanBasePackages = {"com.zy.grpc.server"})
public class GrpcServerApplication {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(GrpcServerApplication.class, args);
		System.out.println(ctx.getId() + " started!");
		BBean bBean = ctx.getBean(BBean.class);
		System.out.println(bBean.toString());
		GrpcServer grpcServer = ctx.getBean(GrpcServer.class);
		grpcServer.awaitTermination();
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GrpcServerApplication.class);
	}

}
