package com.journaldev.bootifulmongodb.dal;

import com.journaldev.bootifulmongodb.model.DeepCrawlDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeepCrawlDetailIntImpl implements  DeepCrawlDetailInt{


    @Autowired
    private MongoTemplate mongoTemplate; // we will use this to query mongoDb

    public List<DeepCrawlDetail> findByUniqueId(String uniqueId){
        Query query = new Query();
        query.addCriteria(Criteria.where("uniqueId").is(uniqueId));
        List<DeepCrawlDetail> DeepCrawlDetailList = mongoTemplate.find(query, DeepCrawlDetail.class);
        return DeepCrawlDetailList;
    }


    @Override
    public String addDeepCrawlDetail(String URL){
        Query query = new Query();
        query.addCriteria(Criteria.where("deepCrawlURL").is(URL));
        List<DeepCrawlDetail> DeepCrawlDetailList = mongoTemplate.find(query, DeepCrawlDetail.class);
        if (DeepCrawlDetailList.size() == 0) {
            DeepCrawlDetail deepCrawlDetail =new DeepCrawlDetail();
            deepCrawlDetail.setDeepCrawlURL(URL);
            mongoTemplate.save(deepCrawlDetail);
            return "success";
        } else {
            return "failure";
        }
    }

}
