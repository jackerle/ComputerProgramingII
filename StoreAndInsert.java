
import java.util.Scanner;
import java.util.ArrayList;

class ProductInfo {
    // Enter your code here and only here.

    public int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public String name;
    public int[] prices = new int[1000];

    ProductInfo(String name, int[] prices) {
        this.name = name;
        this.prices = prices;
    }

    public void calc() {
        for (int i = 0; i < this.prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
            }
        }
    }

    public int getMin() {
        calc();
        return min;
    }
    public int getMax(){
        calc();
        return max;
    }
}

class Store {
    // Enter your new code here and only here.

    private ArrayList<ProductInfo> products = new ArrayList<ProductInfo>();

    public void enterProductInfo(Scanner scan) {
        String name = scan.next();
        int N = scan.nextInt();
        int[] prices = new int[N];
        for (int i=0;i<N;i++){
            prices[i] = scan.nextInt();
        }
        products.add(new ProductInfo(name,prices));
    }
    
    void printAllProductInfo() {
    for (int o=0;o<products.size();o++){
        System.out.println(products.get(o).name+" "+products.get(o).getMin()+" "+products.get(o).getMax());
    }
    }

}

public class StoreAndInsert {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Store store = new Store();
        int K = scan.nextInt();
        for (int i = 0; i < K; ++i) {
            store.enterProductInfo(scan);
        }
        store.printAllProductInfo();
    }
}
