package com.wm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;
import java.util.*;

@SpringBootApplication
@EnableJpaRepositories
public class SpringbootRedisApplication {

    private Logger logger = LoggerFactory.getLogger(SpringbootRedisApplication.class);

    @Resource
    private AmqpTemplate amqpTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisApplication.class, args);
    }

    @RabbitHandler
    @RabbitListener(queues = "string", containerFactory="rabbitListenerContainerFactory")
    public void recieved(String msg) {
        Collection;
        List;
        Set;
        Queue;
        HashMap;
        HashSet;
        ArrayList;
        LinkedList;
        logger.info("[string] recieved message: {}" , msg);
    }

}
