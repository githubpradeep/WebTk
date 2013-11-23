import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep1
 * Date: 21/10/13
 * Time: 01:26
 * To change this template use File | Settings | File Templates.
 */
public class GetProduct {
    public static final int MAXDEPTH=5   ;
	private MyLogger logger = new MyLogger();
    static Set<String> links=new HashSet<String>();
    static final String base="http://www.flipkart.com";
    public void DFS(String url,int depth)
    {
        if(url.contains("http"))
		   return;
        links.add(url);
        Set<String> childLinks=Links.extractLink(base+url);
        for(String link:childLinks)
        {
            if(links.contains(link)==false)
            {
                if(Links.isProductLink(link))
                {
					String pri = Price.getPrice(base+link);
					if(pri!=null)
                    	logger.log(pri);
                }
                if(depth<MAXDEPTH)
                   DFS(link,depth+1);
            }
        }
    }

}
