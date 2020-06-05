package cn.aircas.javabase.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ExecAsyncTaskService implements ApplicationRunner {
    @Autowired
    AsyncTaskService asyncTaskService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        for (int i = 1; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
    }
}
