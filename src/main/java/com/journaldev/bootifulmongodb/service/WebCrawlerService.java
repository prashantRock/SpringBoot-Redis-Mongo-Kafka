package com.journaldev.bootifulmongodb.service;

import com.journaldev.bootifulmongodb.dal.CrawlRequestRepository;
import com.journaldev.bootifulmongodb.dal.DeepCrawlDetailRepository;
import com.journaldev.bootifulmongodb.dto.URLDetailDTO;
import com.journaldev.bootifulmongodb.model.CrawlRequest;
import com.journaldev.bootifulmongodb.model.DeepCrawlDetail;
import com.journaldev.bootifulmongodb.util.Enum;
import com.journaldev.bootifulmongodb.util.ExtractSourcePageData;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
@EnableAsync
public class WebCrawlerService {

    String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public WebCrawlerService(CrawlRequestRepository crawlRequestRepository) {
        this.crawlRequestRepository = crawlRequestRepository;
    }

    @Autowired
    private final CrawlRequestRepository crawlRequestRepository;


    @Autowired
    public  AsyncSourcePageData asyncSourcePageData;

    public String addCrawlRequest(String URL, int depth) {
        String token = base62Encode(Long.parseLong(URL));//use counter

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
