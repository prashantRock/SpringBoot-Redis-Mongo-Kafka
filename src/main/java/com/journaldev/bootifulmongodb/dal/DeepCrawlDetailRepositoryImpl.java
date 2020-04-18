package com.journaldev.bootifulmongodb.dal;

import com.journaldev.bootifulmongodb.model.CrawlRequest;
import com.journaldev.bootifulmongodb.model.DeepCrawlDetail;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class DeepCrawlDetailRepositoryImpl implements DeepCrawlDetailRepository  {

    @Autowired
    private MongoTemplate mongoTemplate; // we will use this to query mongoDb

    public List<DeepCrawlDetail> findByUniqueId(String uniqueId){
        Query query = new Query();
        query.addCriteria(Criteria.where("uniqueId").is(uniqueId));
        List<DeepCrawlDetail> DeepCrawlDetailList = mongoTemplate.find(query, DeepCrawlDetail.class);
        return DeepCrawlDetailList;
    }

}
