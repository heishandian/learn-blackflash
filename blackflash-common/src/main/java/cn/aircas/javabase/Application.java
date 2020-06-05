package cn.aircas.javabase;

import cn.aircas.javabase.http.HttpRestfulTest;
import cn.aircas.javabase.task.AsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	@Autowired
	private static AsyncTaskService asyncTaskService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		HttpRestfulTest.testGget();
	}
}
