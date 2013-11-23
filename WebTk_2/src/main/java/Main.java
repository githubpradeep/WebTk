/**
 * Created with IntelliJ IDEA.
 * User: pradeep1
 * Date: 21/10/13
 * Time: 00:38
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public  static  void main(String []args)
    {
        /*GetProduct g=new GetProduct();
        g.DFS("",0);
*/
        SearchProduct searchProduct=new SearchProduct();
        long t0 = System.nanoTime();
        /*searchProduct.search("canon eos 600d");
        searchProduct.search("xbox controller");
        */searchProduct.search("iphone 5c");
        long t1 = System.nanoTime();
        System.out.println((t1-t0)/1000000000);
    }
}
