package grpc.hello.world;

import grpc.hello.world.models.GreeterGrpc;
import grpc.hello.world.models.HelloReply;
import grpc.hello.world.models.HelloRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.io.IOException;

@GrpcService
public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {

    private static final int PORT = 6999;

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(PORT)
                .addService(new GreeterServiceImpl())
                .build();

        server.start();
        System.out.println("Server started, listening on " + PORT);
        server.awaitTermination();
    }

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
