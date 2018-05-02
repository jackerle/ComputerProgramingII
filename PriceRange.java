
import java.util.Scanner;

class ProductInfo {
    // Enter your code here and only here.
    public int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
    public String name;
    public int [] prices = new  int [1000];
    ProductInfo(String name,int [] prices){
        this.name = name;
        this.prices = prices;   
    }
    public void calc(){
        for (int i=0;i<this.prices.length;i++){
            if( prices[i] < min)min=prices[i];
            if (prices[i]>max)max =prices[i]; 
        }
    }
    public void printInfo(){
       calc();
        System.out.println(this.name+" "+this.min+" "+this.max);
    }
}

public class PriceRange {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int N = scan.nextInt();
        int[] prices = new int[N];
        for (int i = 0; i < N; ++i) {
            prices[i] = scan.nextInt();
        }
        ProductInfo pInfo = new ProductInfo(name, prices);
        pInfo.printInfo();
    }
}
