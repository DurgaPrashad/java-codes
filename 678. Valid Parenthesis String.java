import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftParentheses = new Stack<>();
        Stack<Integer> asterisks = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftParentheses.push(i);
            } else if (c == '*') {
                asterisks.push(i);
            } else { // c == ')'
                if (!leftParentheses.isEmpty()) {
                    leftParentheses.pop();
                } else if (!asterisks.isEmpty()) {
                    asterisks.pop();
                } else {
                    return false;
                }
            }
        }
        
        while (!leftParentheses.isEmpty() && !asterisks.isEmpty()) {
            if (leftParentheses.pop() > asterisks.pop()) {
                return false;
            }
        }
        
        return leftParentheses.isEmpty();
    }
}
