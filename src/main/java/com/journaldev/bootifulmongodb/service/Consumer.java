package com.journaldev.bootifulmongodb.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {


    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    DeepCrawlerDetailService deepCrawlerDetailService;

    @KafkaListener(topics = "test", groupId = "group_id")
    public void consume(String message){
        logger.info(String.format("$$ -> Consumed Message -> %s",message));
        deepCrawlerDetailService.addNewURL(message);
    }


}
