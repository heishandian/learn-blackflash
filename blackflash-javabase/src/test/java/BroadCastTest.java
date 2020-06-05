import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class BroadCastTest {
    @Test
    public void startClient() throws Exception {
        DatagramSocket ds = new DatagramSocket(8080);
        DatagramPacket dp = new DatagramPacket("abc".getBytes(), "abc".length(),new InetSocketAddress("127.0.0.1", 8081));
        ds.send(dp);
    }

    @Test
    public void startServer() throws Exception {
        DatagramSocket ds = new DatagramSocket(8081);
        DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
        ds.receive(dp);
        System.out.println(new String(dp.getData(), dp.getLength()));
    }


}
