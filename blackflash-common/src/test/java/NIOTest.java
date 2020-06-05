import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOTest {
    //1.利用通道来完成文件的复制
    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("iecas.png");
            fos = new FileOutputStream("iecas-copy.png");
            //2.获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            //3.分配一个指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //4.将通道中的数据存入缓冲区中读取数据
            while (inChannel.read(buf) != -1) {
                buf.flip();//切换成读取数据的模式
                //5.将缓冲区中的数据再写入到通道
                outChannel.write(buf);
                //清空缓冲区
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //2.使用直接缓冲区完成文件的复制(内存映射文件的方式)
    @Test
    public void test2() throws IOException {
        long start = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get("iecas.png"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("iecas-copy.png"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();
        long end = System.currentTimeMillis();
        System.out.println("内存映射文件所花时间："+(end-start));
    }

    /**
     * 通道之间的数据传输（直接缓冲区）
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("iecas.png"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("iecas-copy.png"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);
        inChannel.transferTo(0, inChannel.size(), outChannel);
        //outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();
    }
}
