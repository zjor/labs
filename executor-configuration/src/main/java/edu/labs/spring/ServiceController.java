package edu.labs.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;
import java.util.concurrent.Executor;

@Slf4j
@Controller
public class ServiceController {

    @Inject
    @Named("taskExecutor")
    private Executor executor;

    @RequestMapping(name = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> index() {
        final String taskId = UUID.randomUUID().toString();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                    log.info("Task ID: {} completed", taskId);
                } catch (InterruptedException e) {
                }
            }
        });
        log.info("Task ID: {} submitted", taskId);
        return ResponseEntity.ok("task submitted");
    }


}
