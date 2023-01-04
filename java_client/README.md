# Java Client Functions to PostgreSQL connection
## Build
- Use IntelliJ IDEA CE
- build maven
- run package at maven
## Import
```java
import java_client.src.main.java.database_client.Client
```
## Example
```java
public class ClientTest extends TestCase {

    public void testApp() {
        Client client = new Client("0.0.0.0:8080"); // Connect to gRPC Server

        System.out.println(client.getDb("qrcodes_tb")); // Get data from Server PostgreSQL

        List<String> colums = new ArrayList<>();
        colums.add("url");
        colums.add("initer");

        List<String> values = new ArrayList<>();
        values.add("hello.ru");
        values.add("me");

        System.out.println(client.insertDb(colums, values)); // Insert into Server PostgreSQL

        System.out.println(client.deleteDb("qrcodes_tb", "url='hello.ru'")); //Delete from Server PostgreSQL
    }


}
```
