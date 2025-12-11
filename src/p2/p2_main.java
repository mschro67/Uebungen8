//by mschro67

package p2;

import java.lang.String;

public class p2_main{
    public static void main(String[] args){
        System.out.println(shortenToLowerCase("Marco",2));
    }
    public static String shortenToLowerCase(String input,int shortenBy){
        String result="";
        for (int x=0;x<input.length()-shortenBy;x++){
            result+=input.charAt(x);
        }
        return result.toLowerCase();
    }
}
