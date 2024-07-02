package grpc.hello.world;

import grpc.hello.world.models.Person;

public class ExampleProtoMain {
    public static void main(String[] args) {
        Person person = Person.newBuilder().setName("Rayana").setAge(26).build();
        System.out.println("Created an instance Person: " + person);
    }
}
