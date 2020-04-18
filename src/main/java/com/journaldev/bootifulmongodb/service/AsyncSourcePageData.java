package com.journaldev.bootifulmongodb.service;

import com.journaldev.bootifulmongodb.dal.CrawlRequestRepository;
import com.journaldev.bootifulmongodb.dal.DeepCrawlDetailRepository;
import com.journaldev.bootifulmongodb.dto.URLDetailDTO;
import com.journaldev.bootifulmongodb.model.CrawlRequest;
import com.journaldev.bootifulmongodb.util.Enum;
import com.journaldev.bootifulmongodb.util.ExtractSourcePageData;
import com.journaldev.bootifulmongodb.util.ExtractURLTask;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;


@Service
@EnableAsync
public class AsyncSourcePageData  {

    public AsyncSourcePageData(CrawlRequestRepository crawlRequestRepository) {
        this.crawlRequestRepository = crawlRequestRepository;
    }

    private final CrawlRequestRepository crawlRequestRepository;


    public Future<String> asyncMethodWithReturnType() {
        System.out.println("Execute method asynchronously " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            System.out.println("Execute method asynchronously111 " + Thread.currentThread().getName());

            return new AsyncResult<>("hello world !!!!");
        } catch (final InterruptedException e) {

        }

        return null;
    }


    @Async("threadPoolTaskExecutor")
    public void processPageSource(String token, String url, int depth) {


        List<URLDetailDTO> urlDetailDTOList = new ArrayList<>();
        List<String> URLList = new ArrayList<>();
        URLList.add(url);
        int totalImages = 0;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        try {

            for (int i = 0; i < depth; i++) {
                List<String> eachPageURLList = new ArrayList<>();

                for (String URL : URLList) {

                    ExtractURLTask task = new ExtractURLTask();
                    executor.execute(task);
                    Document doc = ExtractSourcePageData.fetchDocument(URL);
                    eachPageURLList.addAll(ExtractSourcePageData.extractURLLinks(doc));
                    List<String> imageResult = ExtractSourcePageData.extractImageLinks(doc);
                    String title = ExtractSourcePageData.extractTitle(doc);
//                    totalImages = totalImages + imageResult.size();
                    urlDetailDTOList.add(new URLDetailDTO(title, URL, imageResult.size()));
                }
                URLList = eachPageURLList;
            }
            crawlRequestRepository.save(new CrawlRequest(token, url, Enum.Status.PROCESSED.toString(), urlDetailDTOList.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            crawlRequestRepository.save(new CrawlRequest(token, url, Enum.Status.FAILED.toString()));
        }
    }

}
