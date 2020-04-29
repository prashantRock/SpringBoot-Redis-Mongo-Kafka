package com.journaldev.bootifulmongodb.controller;


import com.journaldev.bootifulmongodb.service.WebCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class WebCrawlerController {

    @Autowired
    private WebCrawlerService webCrawlerService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, String> addCrawlRequest(
            @RequestParam String URL) {
        String token = webCrawlerService.addCrawlRequest(URL, 2);
        HashMap<String, String> responseMap = new HashMap<>();
        responseMap.put("token", token);
        responseMap.put("status", HttpStatus.OK.getReasonPhrase());
        return responseMap;
    }

    @RequestMapping(value = "/fetchurldetail/{token}", method = RequestMethod.GET)
    public Map<String, Object> getUser(@PathVariable String token) {
        Map<String, Object> responseMap = webCrawlerService.findCrawlURL(token);
        responseMap.put("status", HttpStatus.OK.getReasonPhrase());
        return responseMap;
    }


}
