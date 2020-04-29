package com.journaldev.bootifulmongodb.dal;

import com.journaldev.bootifulmongodb.model.DeepCrawlDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DeepCrawlDetailRepository extends MongoRepository<DeepCrawlDetail, String> {


}
