package database_client;

import api.DatabaseGrpc;
import api.DatabaseOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.ArrayList;
import java.util.List;

public class Client {
    final String HOST = "localhost:8080";

    public ManagedChannel getChan(String host) {
        return ManagedChannelBuilder.forTarget(host).usePlaintext().build();
    }

    public DatabaseGrpc.DatabaseBlockingStub getConn(ManagedChannel channel) {
        return DatabaseGrpc.newBlockingStub(channel);
    }

    public DatabaseOuterClass.GetDbResponse getDb(String tb) {
        ManagedChannel channel = getChan(HOST);
        DatabaseGrpc.DatabaseBlockingStub stub = getConn(channel);


        DatabaseOuterClass.GetDbRequest request = DatabaseOuterClass.GetDbRequest
                .newBuilder().setTb(tb).build();

        DatabaseOuterClass.GetDbResponse response = stub.getDb(request);

        channel.shutdownNow();

        return response;
    }

    public DatabaseOuterClass.InsertDbResponse insertDb(List<String> colums, List<String> values) {
        ManagedChannel channel = getChan(HOST);
        DatabaseGrpc.DatabaseBlockingStub stub = getConn(channel);


        DatabaseOuterClass.InsertDbRequest request = DatabaseOuterClass.InsertDbRequest.newBuilder()
                .setTb("qrcodes_tb").addAllColums(colums).addAllValues(values)
                .build();

        DatabaseOuterClass.InsertDbResponse response = stub.insertDb(request);

        channel.shutdownNow();

        return response;
    }

    public DatabaseOuterClass.DeleteDbResponse deleteDb(String tb, String where) {
        ManagedChannel channel = getChan(HOST);
        DatabaseGrpc.DatabaseBlockingStub stub = getConn(channel);

        DatabaseOuterClass.DeleteDbRequest request = DatabaseOuterClass.DeleteDbRequest.newBuilder()
                .setTb(tb).setWhere(where)
                .build();

        DatabaseOuterClass.DeleteDbResponse response = stub.deleteDb(request);

        channel.shutdownNow();

        return response;
    }
}
