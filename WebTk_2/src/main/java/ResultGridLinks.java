import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep1
 * Date: 11/16/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResultGridLinks {
    public static Set<String> extractLink(String url)
    {
        Set<String> htmlLinks=new HashSet<String>();

        try {
            Document document = Jsoup.connect(url).get();
            Element div = document.select("div.results.grid").first();

            Elements links=div.select("a");
            for (Element link : links)
            {
                htmlLinks.add(link.attr("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return htmlLinks;
    }

}
