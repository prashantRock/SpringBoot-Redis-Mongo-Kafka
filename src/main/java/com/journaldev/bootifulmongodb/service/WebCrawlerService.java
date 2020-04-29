package com.journaldev.bootifulmongodb.service;

import com.journaldev.bootifulmongodb.dal.CrawlRequestRepository;
import com.journaldev.bootifulmongodb.model.CrawlRequest;
import com.journaldev.bootifulmongodb.util.Enum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@EnableAsync
public class WebCrawlerService {

    String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    @Autowired
    private final CrawlRequestRepository crawlRequestRepository;


    public WebCrawlerService(CrawlRequestRepository crawlRequestRepository) {
        this.crawlRequestRepository = crawlRequestRepository;
    }

    @Autowired
    public  AsyncSourcePageData asyncSourcePageData;

    public String addCrawlRequest(String URL, int depth) {
        String token = base62Encode(1234534);//use counter

        crawlRequestRepository.save(new CrawlRequest(token, URL, Enum.Status.SUBMITTED.toString()));
        asyncSourcePageData.processPageSource(token,URL, depth);
        return token;
    }

    public Map<String, Object> findCrawlURL(String token) {
        Map<String, Object> responseMap = new HashMap<>();
        CrawlRequest crawlRequest = crawlRequestRepository.findOne(token);
        responseMap.put("responseMap", crawlRequest);
        return responseMap;
    }


    private String base62Encode(long value) {
        StringBuilder sb = new StringBuilder();
        while (value != 0) {
            sb.append(base62.charAt((int)(value % 62)));
            value /= 62;
        }
        while (sb.length() < 6) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }
}
