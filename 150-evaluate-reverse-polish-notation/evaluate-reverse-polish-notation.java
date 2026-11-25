
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<Integer>();
        int a, b;

        for(String ch : tokens){

            if(ch.equals("+")){
                st.push(st.pop() + st.pop());

            }else if(ch.equals("-")){
                a = st.pop();
                b = st.pop();
                st.push(b - a);

            }else if(ch.equals("*")){
                st.push(st.pop() * st.pop());

            }else if(ch.equals("/")){
                a = st.pop();
                b = st.pop();
                st.push(b / a);

            }else{
                st.push(Integer.parseInt(ch));
            }
        }

        return st.pop();
    }
}
