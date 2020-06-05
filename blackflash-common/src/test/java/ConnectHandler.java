import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.concurrent.Callable;

public class ConnectHandler implements Runnable {

    public static Selector selector = null;
    public static ServerSocketChannel ssChannel = null;

    public ConnectHandler init(Selector selector, ServerSocketChannel ssChannel) {
        this.selector = selector;
        this.ssChannel = ssChannel;
        return this;
    }

    @Override
    public void run() {
        try {
            //10. 若“接收就绪”，获取客户端连接
            SocketChannel sChannel = ssChannel.accept();
            //11. 切换非阻塞模式
            sChannel.configureBlocking(false);
            //12. 将该通道注册到选择器上
            sChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  /*  static class ReadWriteHandler implements Runnable {
        @Override
        public void run() {
            //13. 获取当前选择器上“读就绪”状态的通道
            SocketChannel sChannel = (SocketChannel) ss.channel();

            //14. 读取数据
            ByteBuffer buf = ByteBuffer.allocate(1024);

            int len = 0;
            while ((len = sChannel.read(buf)) > 0) {
                buf.flip();
                System.out.println(new String(buf.array(), 0, len));
                buf.clear();
            }
        }
    }*/
}
