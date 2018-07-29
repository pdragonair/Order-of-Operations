/**
 * Created by pranav.khorana on 6/9/2017.
 */
public class Tester {
    public static void main (String [] args){


        String pre = "4*5-(9+2)+3";
        System.out.println(Pemdas.isValidSymbolPattern(pre));
        String str = Pemdas.postSetup(pre);
        System.out.println(str);


        System.out.println(Pemdas.expressionEvaluation(str));
    }
}
