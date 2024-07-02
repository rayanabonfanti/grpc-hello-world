package grpc.hello.world;

import grpc.hello.world.models.GreeterGrpc;
import grpc.hello.world.models.HelloReply;
import grpc.hello.world.models.HelloRequest;
import io.grpc.stub.StreamObserver;

import java.util.Random;
import java.util.stream.IntStream;

public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {

    private static final String[] names = {
            "Alice", "Bob", "Carol", "Dave", "Eve",
            "Frank", "Grace", "Hank", "Irene", "John",
            "Kyle", "Laura", "Mike", "Nora", "Oscar",
            "Patty", "Quinn", "Rachel", "Steve", "Tina",
            "Uma", "Victor", "Wendy", "Xavier", "Yolanda",
            "Zack"
    };

    private static final Random random = new Random();

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) throws InterruptedException {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
        IntStream.range(0, 1000)
                .mapToObj(i -> (i + 1) + " - " + getRandomName())
                .forEach(System.out::println);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    private static String getRandomName() {
        int index = random.nextInt(names.length);
        return names[index];
    }

}
