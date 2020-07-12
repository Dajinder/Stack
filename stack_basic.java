import java.util.Scanner;
import java.util.Stack;
public class stack_basic{
    public static void main(String[] args) throws Exception{
        solve();
    }

    public static void solve(){
        // duplicatebrackets();
        // validParenthesis();
        addDuplicate();
    }
    public static void duplicatebrackets(){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack<Character> st = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch == ')'){
                if(st.peek()=='('){
                    System.out.println("true : duplicate brackets are present");
                    return;
                }else{
                    while(st.peek()!='('){
                        st.pop();
                    }
                    st.pop();
                }
                
            }else{
                st.push(ch);
            }
        }
        System.out.println("false : duplicate brackets are not present");
    }

    public static void validParenthesis(){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack<Character>st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else if(ch == ')'){
                if(st.size()==0){
                    System.out.println(false);
                    return;
                }
                else if(st.peek()!='('){
                    System.out.println(false);
                    return;
                }
                else{
                    st.pop();
                }
            }
            else if(ch == ']'){
                if(st.size()==0){
                    System.out.println(false);
                    return;
                }
                else if(st.peek()!='['){
                    System.out.println(false);
                    return;
                }
                else{
                    st.pop();
                }
            }
            else if(ch == '}'){
                if(st.size()==0){
                    System.out.println(false);
                    return;
                }
                else if(st.peek()!='{'){
                    System.out.println(false);
                    return;
                }
                else{
                    st.pop();
                }
            }
            else{

            } 
        }
        if(st.size()==0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
    
    public static void addDuplicate(){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == st.peek() && st.size()!=0){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        while(st.size()!=0){
            System.out.println(st.pop());
        }
    }

}