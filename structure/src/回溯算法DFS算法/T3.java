package 回溯算法DFS算法;

import java.util.*;

/**
 * @author fangsheng
 * @date 2021/4/7 下午2:09
 */
public class T3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        System.out.println(t3.generateParenthesis2(3));
    }

    static boolean isValid(String str) {
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                left++;
            } else {
                left--;
            }
            if (left < 0) {
                return false;
            }
        }
        return left == 0;
    }

    boolean isValid2(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                // 字符c是右括号
            } else {
                if (!stack.isEmpty() && leftOf(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    char leftOf(char c) {
        if (c == '}') {
            return '{';
        }
        if (c == ')') {
            return '(';
        }
        return '[';
    }

    public boolean isValid3(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    /**
     * dfs算法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<String>();
        dfs(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void dfs(List<String> ans, StringBuilder cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (left < max) {
            cur.append('(');
            dfs(ans, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(')');
            dfs(ans, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
