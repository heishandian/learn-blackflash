package cn.aircas.javabase.http;

import org.springframework.web.client.RestTemplate;

public class HttpRestfulTest {
    static RestTemplate restTemplate = new RestTemplate();

    public static void testGget() {
        App[] apps = restTemplate.getForObject("http://localhost:8070/apps", App[].class);
        System.out.println(apps);
    }
}
