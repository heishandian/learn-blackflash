package cn.aircas.javabase.io;

import cn.aircas.javabase.Utiles;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

public class IOUtilesTest {

    @Test
    public void getFileContent() throws Exception {
        String filePath = "C:\\Users\\kk\\Desktop\\4-26xt.txt";
        String code = Utiles.codeString(filePath);
        InputStream inputStream = new FileInputStream(filePath);
        String fileContent = IOUtils.toString(inputStream, code);
        System.out.println(fileContent);
    }
}
