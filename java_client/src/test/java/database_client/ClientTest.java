package database_client;

import api.DatabaseGrpc;
import api.DatabaseOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class ClientTest extends TestCase {

    public void testApp()
    {
        Client client = new Client("0.0.0.0:8080");

        System.out.println(client.getDb("qrcodes_tb"));

        List<String> colums = new ArrayList<>();
        colums.add("url");
        colums.add("initer");

        List<String> values = new ArrayList<>();
        values.add("hello.ru");
        values.add("me");

        System.out.println(client.insertDb(colums, values));

        System.out.println(client.deleteDb("qrcodes_tb", "url='hello.ru'"));
    }


}
