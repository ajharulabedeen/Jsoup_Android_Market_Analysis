
import java.io.BufferedReader;
import java.io.FileReader;
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
public class jSoup_AdditionalInfo {

    public static void main(String[] args) {
            analysis();
//            getInfo();
    }//main

    public static void analysis() {
        String FILENAME = "voca_additional_info.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;
            int count=0;
            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println(sCurrentLine);
                String[] s = sCurrentLine.split(";");
//                System.out.println(s[0]);//date
//                System.out.println(s[1]);//size
//                System.out.println(s[2].replace("+", ""));//install
//                start : price printing
                if(sCurrentLine.contains("BDT"))
                {
                    for (int i = 0; i < s.length; i++) {
                        if(s[i].contains("BDT"))
                        {
                            System.out.println(s[i].replace("per item", ""));
                            count++;
                        }
                    }//for
                }//if
                else{
                    System.out.println(0);
                }
            }//while
            System.out.println("Price Count : "+count);
//                end : price printing
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//analysis

    /**
     * this will down the information from given link that are saved in txt file.
     */
    public static void getInfo() {
        String FILENAME = "voca_links.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                printInfo(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//getInfo

    public static void printInfo(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Element element = doc.getElementsByClass("xyOfqd").get(0);
            Elements elements_htlgb = element.getElementsByClass("htlgb");
//            System.out.println(elements_htlgb.size());
            int x = 0;
            for (Element element_htlgb : elements_htlgb) {
                Elements e_s = element_htlgb.getAllElements();
//                System.out.println(e_s.size()+"-------");
                if (e_s.size() == 1) {
//                    System.out.print(element_htlgb.text() + ">");
                    System.out.print(element_htlgb.text() + ";");
                }
            }//for
            System.out.println("");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//printInfo

    public static void name_link(Element elementMain) {
        int x = 0;
        Elements elements = elementMain.getAllElements();
        for (Element element : elements) {
            String playUrl = "https://play.google.com";
//                System.out.println(x++);
            String fullLink = element.attr("href");
            if (fullLink.contains("/store/apps/details")) {
//                System.out.println(playUrl + fullLink);
                String title = element.attr("title");
                if (!title.isEmpty()) {
                    System.out.println(title);
                    break;
                }//if
            }//if
        }//for
    }//name_link()
}//class

//working BackUp code.
//String url = "https://play.google.com/store/apps/details?id=com.usefulappsbd.bcs_preparation";
//        try {
//            Document doc = Jsoup.connect(url).get();
//            Element element = doc.getElementsByClass("xyOfqd").get(0);
//            Elements elements_htlgb = element.getElementsByClass("htlgb");
//            System.out.println(elements_htlgb.size());
//            int x = 0;
//            for (Element element_htlgb : elements_htlgb) {
//                Elements e_s = element_htlgb.getAllElements();
////                System.out.println(e_s.size()+"-------");
//                if (e_s.size() == 1) {
////                    System.out.println(element_htlgb.toString());
//                    System.out.print(element_htlgb.text() + ">");
////                    System.out.println(element_htlgb.text());
//                }
//            }//for
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
