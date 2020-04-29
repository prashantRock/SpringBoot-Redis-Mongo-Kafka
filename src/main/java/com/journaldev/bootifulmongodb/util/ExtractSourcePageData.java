package com.journaldev.bootifulmongodb.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ExtractSourcePageData {



    public static Document fetchDocument(String url) throws Exception{
       return  Jsoup.connect(url).get();
    }

    public static List<String> extractURLLinks(Document doc) throws Exception {
        final ArrayList<String> result = new ArrayList<>();
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            result.add(link.attr("abs:href"));
        }
            return result;
    }

    public static List<String> extractImageLinks(Document doc) throws Exception {
        final ArrayList<String> result = new ArrayList<>();
        Elements links = doc.select("img[href]");
        for (Element link : links) {
            result.add(link.attr("abs:href"));
        }
        return result;
    }

    public static String extractTitle(Document doc) throws Exception {
        return doc.title();
    }
}
