import java.util.Stack;

public class StackSolution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        boolean[] isVisited = new boolean[26];
        int[] cnt = new int[26];
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); cnt[s.charAt(i) - 'a']--, i++) {
            if (isVisited[s.charAt(i) - 'a'] || !stack.empty() && stack.peek() == s.charAt(i)) {
                continue;
            }

            while (!stack.empty() && stack.peek() > s.charAt(i) && cnt[stack.peek()] > 0) {
                isVisited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(s.charAt(i));
            isVisited[s.charAt(i) - 'a'] = true;
        }
        
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
