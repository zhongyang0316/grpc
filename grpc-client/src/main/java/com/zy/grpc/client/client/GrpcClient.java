package com.zy.grpc.client.client;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zy.grpc.common.protobuf.PersonProbuf.Person;
import com.zy.grpc.common.protobuf.PersonProbuf.Req;
import com.zy.grpc.common.protobuf.PersonProbuf.Resp;
import com.zy.grpc.common.protobuf.UserServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient implements Closeable{
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	//GRPC的Client与Server，均通过Netty Channel作为数据通信，序列化、反序列化则使用Protobuf，
	//每个请求都将被封装成HTTP2的Stream，在整个生命周期中，客户端Channel应该保持长连接，而不是每次调用重新创建Channel、响应结束后关闭Channel（即短连接、交互式的RPC），
	//目的就是达到链接的复用，进而提高交互效率
	private ManagedChannel channel;
	
	private UserServiceGrpc.UserServiceBlockingStub blockingStub;
	
	public GrpcClient(String host, int port){
		this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();  
        this.blockingStub = UserServiceGrpc.newBlockingStub(this.channel);
	}
	
	public Person query(String userName) {
		Req req = Req.newBuilder().setUsername(userName).build();  
        Resp resp = blockingStub.query(req);  
        return resp.getPerson();
	}

	@Override
	public void close() throws IOException {
		this.logger.info("关闭GrpcClient...");
		if (this.blockingStub != null) {
			this.blockingStub = null;
		}
		if (this.channel != null) {
			if (!this.channel.isShutdown()) {
				this.channel.shutdownNow();
			}
			this.channel = null;
		}
	}

}
