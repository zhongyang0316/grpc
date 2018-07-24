package com.zy.grpc.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zy.grpc.common.protobuf.PersonProbuf;
import com.zy.grpc.common.protobuf.PersonProbuf.Req;
import com.zy.grpc.common.protobuf.PersonProbuf.Resp;
import com.zy.grpc.common.protobuf.UserServiceGrpc.UserServiceImplBase;

import io.grpc.stub.StreamObserver;

public class UserServiceImpl extends UserServiceImplBase {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void query(Req request, StreamObserver<Resp> responseObserver) {
		this.logger.info("接收到客户端请求:{}", request);
		//业务逻辑处理
		PersonProbuf.Person rp = PersonProbuf.Person.newBuilder()  
                .setUsername(request.getUsername()).setAge(100).setSex("M").build();  
        Resp resp = Resp.newBuilder().setPerson(rp).build();  
        responseObserver.onNext(resp);  
        responseObserver.onCompleted();
	}

}
