package com.zy.grpc.server.server;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zy.grpc.server.service.UserServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer implements Closeable {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private Server server;
	
	public GrpcServer(int port){
		this.server = ServerBuilder.forPort(port).addService(new UserServiceImpl()).build();
	}
	
	public void start() throws Exception {
		this.logger.info("GrpcServer Start...");
		this.server.start();
	}
	
	public void awaitTermination() throws Exception{
		this.server.awaitTermination();
	}

	@Override
	public void close() throws IOException {
		this.logger.info("GrpcServer Close...");
		if (this.server != null) {
			this.server.shutdownNow();
			this.server = null;
		}
	}
	
//	private class UserServiceImpl extends UserServiceImplBase {
//		
//		private final Logger logger = LoggerFactory.getLogger(getClass());
//		
//		@Override
//		public void query(Req request, StreamObserver<Resp> responseObserver) {
//			this.logger.info("接收到客户端请求:{}", request);
//			//业务逻辑处理
//			PersonProbuf.Person rp = PersonProbuf.Person.newBuilder()  
//                    .setUsername(request.getUsername()).setAge(100).setSex("M").build();  
//            Resp resp = Resp.newBuilder().setPerson(rp).build();  
//            responseObserver.onNext(resp);  
//            responseObserver.onCompleted();
//		}
//	}

}
