package com.self.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SelfApplication implements CommandLineRunner {
    private static final Log logger = LogFactory.getLog(SelfApplication.class);
    private volatile int count = 1;

    public static void main(String[] args) {
        SpringApplication.run(SelfApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        var threads = new Thread[2];
        for (Thread thread : threads) {
            thread = new Thread(() -> count = count + 1);
            thread.start();
        }
        Thread.sleep(3000);
        logger.info(count);
    }
}
