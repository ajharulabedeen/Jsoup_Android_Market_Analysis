/**
 * It is test file and it has been to the main file.
 */
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
public class jSoup_file_AppLink {

    public static void main(String[] args)  {
        String fileName = "oneApp.html";
        try {
            int x=0;
            Document doc = Jsoup.parse(new File(fileName), "utf-8");
            Elements elements = doc.getElementsByTag("a");
//            Elements elements = doc.getElementsByAttribute("href");
            for (Element element : elements) {
                String playUrl = "https://play.google.com";
                System.out.println(x++);
                String fullLink = element.attr("href");
                if(fullLink.contains("/store/apps/details"))
                {
                    System.out.println(playUrl+fullLink);
//                    System.out.println(">"+element.attr("alt")+"<");
                    System.out.println(">"+element.attr("title")+"<");
                }
            }//for
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//main
}//class
