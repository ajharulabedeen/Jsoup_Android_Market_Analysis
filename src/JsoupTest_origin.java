import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.*;
import java.net.URLEncoder;

public class JsoupTest_origin 
  {
    public static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.59 Safari/537.36";
    
    public static void main(String[] args) throws Exception
      {
            final String query = "android";
//            String url="https://play.google.com/store/apps/details?id=com.bcsprostuti.tanim.bcsprostuti";
            String url="https://play.google.com/store/search?q=bcs";
            final Document page = Jsoup.connect(url).userAgent(USER_AGENT).get();
            
            System.out.println(page.outerHtml());
            
            File file = new File(query+".html");
//            File file = new File(query+".txt");
//            String content = "This is the text content";
            String content = page.outerHtml();

          try (FileOutputStream fop = new FileOutputStream(file))
            {
              // if file doesn't exists, then create it
              if (!file.exists())
                {
                  file.createNewFile();
                }

              // get the content in bytes
              byte[] contentInBytes = content.getBytes();

              fop.write(contentInBytes);
              fop.flush();
              fop.close();

              System.out.println("Done");

            } catch (IOException e)
            {
              e.printStackTrace();
            }
      }//main
    
  }//class
