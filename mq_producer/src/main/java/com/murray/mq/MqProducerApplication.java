package com.murray.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Murray
 * @date 2021/5/6 13:26
 */
@SpringBootApplication
public class MqProducerApplication {


    public static void main(String[] args) throws IOException, TimeoutException {
        SpringApplication.run(MqProducerApplication.class, args);

    }

}
