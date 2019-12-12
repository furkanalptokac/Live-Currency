package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "http://www.tcmb.gov.tr/kurlar/today.xml";
        String data = Jsoup.connect(url).execute().body();
        Document document = Jsoup.parse(data, "", Parser.xmlParser());
        Elements elements = document.select("Currency");

        for (Element el : elements) {
            String isim = el.getElementsByTag("Isim").text();
            String buying = el.getElementsByTag("ForexBuying").text();
            String selling = el.getElementsByTag("ForexSelling").text();
            System.out.println("TRY to " + isim + " Buying: " + buying + " Selling: " + selling);
        }
    }
}
