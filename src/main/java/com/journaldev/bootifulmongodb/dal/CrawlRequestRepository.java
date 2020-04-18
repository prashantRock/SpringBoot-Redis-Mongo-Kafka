package com.journaldev.bootifulmongodb.dal;

import com.journaldev.bootifulmongodb.model.CrawlRequest;
import com.mongodb.DBCursor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrawlRequestRepository extends MongoRepository<CrawlRequest, String> {

}
