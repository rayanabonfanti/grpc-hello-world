package grpc.hello.world;

import io.grpc.ServerBuilder;

public class Main {

    public static void main(String[] args) throws Exception{
        var serverBuilder = ServerBuilder.forPort(6565)
                .addService(new GreeterServiceImpl())
                .build();

        serverBuilder.start();

        System.out.println("Application started with gRPC port: " + serverBuilder.getPort());

        serverBuilder.awaitTermination();
    }

}
