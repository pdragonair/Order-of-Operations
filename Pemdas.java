import java.util.Stack;
import java.util.HashMap;

/**
 * Created by pranav.khorana on 7/27/2018.
 */
public class Pemdas {


    public static boolean isValidSymbolPattern(String s){
        Stack<Character> stk = new Stack<Character>();
        if (s == null || s.length() == 0)
            return true;
        for (int i = 0; i<s.length(); i++){
            if (s.charAt(i) == ')'){
                if(!stk.isEmpty() && stk.peek() == '(')
                    stk.pop();
                else
                    return false;
            }
            else if (s.charAt(i) == ']'){
                if(!stk.isEmpty() && stk.peek() == '[')
                    stk.pop();
                else
                    return false;
            }
            else if (s.charAt(i) == '}'){
                if(!stk.isEmpty() && stk.peek() == '{')
                    stk.pop();
                else
                    return false;
            }else{
                stk.push(s.charAt(i));
            }
        }
        if (stk.isEmpty())
            return true;
        else
            return false;
    }

//    public static String postSetup(String s){
//        Stack<Character> post = new Stack<Character>();
//        String newString = "";
//        for(int i = 0; i < s.length(); i++){
//            if (s.charAt(i) != '(' && s.charAt(i) != ')' && s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '/' && s.charAt(i) != '*') {
//                newString += s.charAt(i);
//            }
//            else if (s.charAt(i) == ')'){
//                while(post.peek() != '(')
//                    newString += post.pop();
//                if(post.peek() == '(')
//                    post.pop();
//                }
//            else{
//                if(s.charAt(i) == '*' || s.charAt(i) == '/') {
//                    while(!post.isEmpty() && (post.peek() != '(' || post.peek() != '+' || post.peek() != '-')) {
//                        newString += post.pop();
//                    }
//                }
//                if(s.charAt(i) == '+' || s.charAt(i) == '-') {
//                    while (!post.isEmpty() && post.peek() != '(') {
//                        newString += post.pop();
//                    }
//                }
//                post.push(s.charAt(i));
//            }
//        }
//        while(!post.isEmpty()){
//            newString += post.pop();
//        }
//        return newString;
//
//    }


    public static String postSetup(String s){
        Stack<Character> post = new Stack<Character>();
        String newString = "";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('*', 3);
        hashMap.put('/', 3);
        hashMap.put('+', 2);
        hashMap.put('-', 2);
        hashMap.put('(', 1);
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if (a != '(' && a != ')' && a != '+' && a != '-' && a != '/' && a != '*') {
                newString += a;
            }
            else if (a == ')'){
                while(post.peek() != '(')
                    newString += post.pop();
                if(post.peek() == '(')
                    post.pop();
            }
            else{
                while(!post.isEmpty() && (a != '(' && hashMap.get(post.peek()) >= hashMap.get(a)) ) {
                        newString += post.pop();
                }
                post.push(s.charAt(i));
            }
        }
        while(!post.isEmpty()){
            newString += post.pop();
        }
        return newString;

    }


    public static int expressionEvaluation(String str) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < str.length(); i++){
            String a = str.substring(i, i+1);

            if (a.equals("+")){
                int op1 = s.pop();
                int op2 = s.pop();
                int res = op1 + op2;
                s.push(res);
            }
            else if (a.equals("-")){
                int op1 = s.pop();
                int op2 = s.pop();
                int res = op2 - op1;
                s.push(res);
            }
            else if (a.equals("*")){
                int op1 = s.pop();
                int op2 = s.pop();
                int res = op1 * op2;
                s.push(res);
            }
            else if (a.equals("/")){
                int op1 = s.pop();
                int op2 = s.pop();
                int res = op1 / op2;
                s.push(res);
            }
            else{
                s.push(Integer.parseInt(a));
            }

        }
        return s.pop();
    }





}
