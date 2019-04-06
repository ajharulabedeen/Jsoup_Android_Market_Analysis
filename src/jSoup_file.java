
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
public class jSoup_file {

    public static void main(String[] args)  {
        String fileName = "android.html";
        int[][] freq = new int[50][1];
        try {
            Document doc = Jsoup.parse(new File(fileName), "utf-8");
            Element divTag = doc.getElementById("mydiv");
//            System.out.println(divTag.text());
            Elements elements = divTag.getAllElements();
            int x=0;
            int out_50=0;
            for (Element element : elements) {
                System.out.println(x++);
                int y=0;
                Elements elements1 = element.getAllElements();
                for (Element element1 : elements1) {
//                    System.out.println(y++);
                        y++;
                }//for
                System.out.println("y : "+y);
                if(y<50)
                {
                    freq[y][0]++;
                }
                else
                {
                    out_50++;
                }
            }//for
            
            System.out.println("out_50 : "+out_50);
            for (int i = 0; i < freq.length; i++) {
                int j = freq[i][0];
                System.out.println(" i : "+i+" > "+j);
            }//for
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//main
}//class
