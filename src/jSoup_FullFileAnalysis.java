
import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author neom
 */
public class jSoup_FullFileAnalysis {

    public static void main(String[] args) {
//        String fileName = "bcs.html";
        String fileName = "voca.html";
//        String url = "https://play.google.com/store/search?q=bcs&c=apps";
//        String url = "https://play.google.com/store/search?q=vocabulary&c=apps";
        
        try {
            Document doc = Jsoup.parse(new File(fileName), "utf-8");
            Element divTag = doc.getElementById("mydiv");
            Elements elements = divTag.getElementsByClass("card no-rationale square-cover apps small");
            
//this will print only 50 names
//            Document doc = Jsoup.connect(url).get();
//            Elements elements = doc.getElementsByClass("card no-rationale square-cover apps small");
            
            for (Element element : elements) {
//                System.out.println(x++);
                name_link(element);
            }//for            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//main

    public static void name_link(Element elementMain) {
        int x = 0;
        Elements elements = elementMain.getAllElements();
        for (Element element : elements) {
            String playUrl = "https://play.google.com";
//                System.out.println(x++);
            String fullLink = element.attr("href");
            if (fullLink.contains("/store/apps/details")) {

                System.out.println(playUrl + fullLink);
                break;
//                String title = element.attr("title");
//                if (!title.isEmpty()) {
//                    System.out.println(title);
//                    break;
//                }

            }
        }//for
    }//name_link()
}//class
