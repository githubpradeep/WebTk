import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep1
 * Date: 21/10/13
 * Time: 00:08
 * To change this template use File | Settings | File Templates.
 */
public class Links {

    public static  Set<String> extractLink(String url)
    {
        Set<String> htmlLinks=new HashSet<String>();

        try {
            Document  document = Jsoup.connect(url).get();
            Elements links=document.select("a");
            for (Element link : links)
            {
                    htmlLinks.add(link.attr("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return htmlLinks;
    }
    public static boolean isProductLink(String url)
    {

        Pattern pattern=Pattern.compile("[\\?&]([^&=]+)=([^&=]+)");
        Matcher matcher=  pattern.matcher(url);
        while(matcher.find()){
            if(matcher.group(1).equals("pid"))
                return true;
        }
        return false;
    }


}
