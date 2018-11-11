package stacksandqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Check condition on each character
 *      if closed bracket, stack should not be empty and top of stack should have balanced bracket - fail
 *                         else pop from stack - continue
 *      if open bracket, just push to stack - continue
 *      at the end stack should be empty
 */
public class IsParenBalanced {

    static Map<Integer, Integer> pairsMap = new HashMap<>();

    static {
        pairsMap.put((int) '}', (int) '{');
        pairsMap.put((int) ']', (int) '[');
        pairsMap.put((int) ')', (int) '(');
    }

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Integer> stack = new Stack<>();
        IntStream chars = s.chars();

        OptionalInt result = chars.filter(c -> isNonValidParen(c, stack)).findFirst();
        return ((!stack.isEmpty() || result.isPresent()) ? "NO" : "YES");
    }

    static boolean isNonValidParen(int c, Stack<Integer> stack) {
        if (pairsMap.keySet().contains(c)) {
            if (stack.isEmpty() || !stack.peek().equals(pairsMap.get(c))) return true;
            stack.pop();
            return false;
        } else {
            stack.push(c);
            return false;
        }
    }

    public static void main(String args[]) {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("", "YES");
        testMap.put("[]", "YES");
        testMap.put("[", "NO");
        testMap.put("]", "NO");
        testMap.put("({[]})", "YES");
        testMap.put("({[[]})", "NO");
        testMap.put("({[]})}", "NO");
        testMap.put("(({{[[()]]}}))", "YES");

        for (Map.Entry<String, String> e : testMap.entrySet()) {
            if (isBalanced(e.getKey()).equals(e.getValue()))
                System.out.println("Input: " + e.getKey() + " -> " + " PASSED");
            else System.out.println("Input: " + e.getKey() + " -> " + " FAILED");
        }
    }
}



