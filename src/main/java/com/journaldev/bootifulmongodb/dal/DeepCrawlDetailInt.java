package com.journaldev.bootifulmongodb.dal;

import com.journaldev.bootifulmongodb.model.DeepCrawlDetail;

import java.util.List;


public interface DeepCrawlDetailInt {

    List<DeepCrawlDetail> findByUniqueId(String uniqueId);

    String addDeepCrawlDetail(String URL);

}
