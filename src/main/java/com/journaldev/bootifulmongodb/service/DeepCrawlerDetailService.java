package com.journaldev.bootifulmongodb.service;

import com.journaldev.bootifulmongodb.dal.DeepCrawlDetailInt;
import com.journaldev.bootifulmongodb.dal.DeepCrawlDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeepCrawlerDetailService {

    @Autowired
    private DeepCrawlDetailInt deepCrawlDetailInt;

    public DeepCrawlerDetailService(DeepCrawlDetailInt deepCrawlDetailInt) {
        this.deepCrawlDetailInt = deepCrawlDetailInt;
    }

    public void addNewURL(String message) {
        deepCrawlDetailInt.addDeepCrawlDetail(message);
    }

}
