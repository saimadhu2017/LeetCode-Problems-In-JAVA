import java.util.*;
public class BalancedBrackets{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(f(s));
        sc.close();
    }
    public static String f(String s){
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='}' || s.charAt(i)==']' || s.charAt(i)==')'){
                if(stack.isEmpty()){
                    return("UnBalanced");
                }
                else{
                    switch(s.charAt(i)){
                        case('}'): if(stack.peek()=='{'){
                                        stack.pop();
                                        break;
                                   }
                                   return("Unbalanced");
                        case(']'): if(stack.peek()=='['){
                                       stack.pop();
                                       break;
                                    }
                                    return("Unbalanced");
                        case(')'): if(stack.peek()=='('){
                                        stack.pop();
                                        break;
                                    }
                                    return("Unbalanced");
                        default: return("Unbalanced");
                    }
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        
        if(stack.isEmpty()){
            return("Balanced String");
        }
        else{
            return("UnBalanced");
        }

    }
}


//refernce for stack class--:
//https://www.geeksforgeeks.org/stack-class-in-java/