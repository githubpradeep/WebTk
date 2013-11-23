import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep1
 * Date: 21/10/13
 * Time: 02:01
 * To change this template use File | Settings | File Templates.
 */
public class Price {
    public static String getPrice(String url)
    {
        String price="";
        String title="";
        String imgUrl="";

        try
        {
            Document doc= Jsoup.connect(url).get();
            price=doc.select("meta[itemprop=price]").first().attr("content");
            title=doc.select("meta[name=og_title").first().attr("content");
            imgUrl=doc.select("img[src$=.jpeg]").first().attr("src");


        }
		catch (Exception e)
        {
			System.out.println(e);
			return null;
        }
        return title+" at price: "+price+" "+imgUrl;
    }
}
