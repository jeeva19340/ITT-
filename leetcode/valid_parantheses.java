import java.util.Stack;

public class DynamicValidParentheses {
    
    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 1. If it's an opening bracket, push its expected closing pair
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // 2. If it's a closing bracket, validate it against the stack
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
            // 3. Dynamic content (letters, numbers, spaces, etc.) is ignored
        }

        // If the stack is empty, all encountered brackets were matched correctly
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Test Case 1: Dynamic string with valid code/text
        System.out.println(isValid("if (x == 0) { return; }")); // Output: true

        // Test Case 2: Dynamic string with mismatched brackets
        System.out.println(isValid("function(test) { x = (1 + 2]; }")); // Output: false

        // Test Case 3: Text with no brackets at all
        System.out.println(isValid("Hello World 123!"));                 // Output: true
    }
}
