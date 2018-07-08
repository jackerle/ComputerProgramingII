import java.util.Scanner;
public class DivideString {

    public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
String big = "";
String small = "";
String sign = "";
String inp = scan.nextLine();
for (int i=0;i<inp.length();i++){
    if ((int)inp.charAt(i)>=65&&(int)inp.charAt(i)<=90){
        big = big+inp.charAt(i);
    }
    else if ((int)inp.charAt(i)>=97&&(int)inp.charAt(i)<=122){
        small  = small+inp.charAt(i);
    }
    else {
        sign = sign+inp.charAt(i);
    }
    
}
                System.out.println(small);
                System.out.println(big);
                System.out.println(sign);
    }
    
}
