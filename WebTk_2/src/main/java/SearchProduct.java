import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep1
 * Date: 11/16/13
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchProduct {

    private MyLogger logger = new MyLogger();
    public void search(String prodName)
    {
        String url="http://www.flipkart.com/search?q=";
        prodName=prodName.trim().replaceAll(" +", "+");
        url+=prodName;
        try {
            Document document= Jsoup.connect(url).get();
            Elements elements=document.select("div.product-unit");
            int count=0;
            for(Element element:elements)
            {
                if(count==5)break;
                count++;
                String s=element.select("a.fk-display-block").first().attr("title");
                String prodLink=element.select("a.fk-display-block").first().attr("href");
                String img=element.select("img").first().attr("data-src");
                if(img=="")
                    img=element.select("img").first().attr("src");

                String price=element.select("div.pu-final span") .text();

              logger.log(s+" at price "+price+" image url "+img+" link to product "+prodLink);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
