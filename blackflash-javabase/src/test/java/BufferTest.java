import org.junit.Test;

import java.nio.ByteBuffer;

public class BufferTest {

    @Test
    public void test() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.put("abcde".getBytes());

        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.flip();
        System.out.println("------------------");

        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        System.out.println("------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

    }
}
