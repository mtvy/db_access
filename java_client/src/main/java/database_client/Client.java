package database_client;

import api.DatabaseGrpc;
import api.DatabaseOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext().build();

        DatabaseGrpc.DatabaseBlockingStub stub =
                DatabaseGrpc.newBlockingStub(channel);

        DatabaseOuterClass.GetDbRequest get_request = DatabaseOuterClass.GetDbRequest
                .newBuilder().setTb("qrcodes_tb").build();

        DatabaseOuterClass.GetDbResponse get_response = stub.getDb(get_request);

        System.out.println(get_response);


        List<String> colums = new ArrayList<String>();
        colums.add("url");
        colums.add("initer");

        List<String> values = new ArrayList<String>();
        values.add("hello.ru");
        values.add("me");

        DatabaseOuterClass.InsertDbRequest insert_request = DatabaseOuterClass.InsertDbRequest.newBuilder()
                .setTb("qrcodes_tb").addAllColums(colums).addAllValues(values)
                .build();

        DatabaseOuterClass.InsertDbResponse insert_response = stub.insertDb(insert_request);

        System.out.println(insert_response);


        DatabaseOuterClass.DeleteDbRequest delete_request = DatabaseOuterClass.DeleteDbRequest.newBuilder()
                .setTb("qrcodes_tb").setWhere("url='hello.ru'")
                .build();

        DatabaseOuterClass.DeleteDbResponse delete_response = stub.deleteDb(delete_request);

        System.out.println(delete_response);


        channel.shutdownNow();
    }
}
