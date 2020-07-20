import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
public class stack_basic{
    public static void main(String[] args) throws Exception{
        solve();
    }

    public static void solve(){
        // duplicatebrackets();
        // validParenthesis();
        // addDuplicate();
        // ngor();
        
        
        // int[] arr = {2,5,9,3,1,12,6,8,7};
        // ngor_alternate(arr);
        // nsor(arr);
        // ngol(arr);
        // nsol(arr);
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
            if(st.size()==0){
                st.push(ch);
            }
            if(ch == st.peek()){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        int size = st.size();
        while(size!=0){
            char x = st.peek();
            System.out.println(x);
            st.pop();
            size--;
        }
    }

    // ngor = next greater on right
    // nsor = next smaller on right
    // ngol = next greater on left
    // nsol = next smaller on left
    public static void ngor(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }

        int[] nge = new int[arr.length];
        Stack<Integer>st = new Stack<>();
        nge[arr.length-1] = -1;
        st.push(arr[arr.length-1]);

        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]>=st.peek()){
                st.pop();
            }

            if(st.size()==0){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }
        for(int i=0;i<nge.length;i++){
            System.out.println(nge[i]);
        }
    }

    public static void ngor_alternate(int[] arr){
        Stack<Integer>st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                int pos = st.peek();
                ans[pos] = arr[i];
                st.pop();
            }
            st.push(i);

        }

        while(st.size()>0){
            int pos = st.peek();
            ans[pos] = -1;
            st.pop();
        }

        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }

    public static void nsor(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=0;i<arr.length;i++){
            while(st.size()!=0 && arr[i]<arr[st.peek()]){
                int pos = st.peek();
                ans[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(st.size()!=0){
            int pos = st.peek();
            ans[pos] = -1;
            st.pop();
        }
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }


    public static void ngol(int[] arr){
        Stack<Integer>st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()!=0 && arr[i]>arr[st.peek()]){
                int pos = st.peek();
                ans[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }

        while(st.size()!=0){
            int pos = st.peek();
            ans[pos] = -1;
            st.pop();
        }

        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }


    public static void nsol(int[] arr){
        Stack<Integer>st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()!=0 && arr[i] < arr[st.peek()]){
                int pos = st.peek();
                ans[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }

        while(st.size()!=0){
            int pos = st.peek();
            ans[pos] = -1;
            st.pop();
        }

        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}