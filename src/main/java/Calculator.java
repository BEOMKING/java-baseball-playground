import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    public int calculate(String input) {
        if(isBlank(input)) throw new RuntimeException();
        return splitAndCalulate(input);
    }

    private boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
    
    private int splitAndCalulate(String input) {
        int start = 0;
        Deque<Integer> number = new ArrayDeque<>();
        Queue<Character> operation = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if(now == '*' || now == '+' || now == '-' || now == '/') {
                number.addLast(Integer.parseInt(input.substring(start, i)));
                start = i + 1;
                operation.add(now);
            }
        }
        number.addLast(Integer.parseInt(input.substring(start)));
        
        while(number.size() > 1) {
            int first = number.pollFirst();
            int second = number.pollFirst();
            char oper = operation.poll();
            if(oper == '+') number.addFirst(first + second);
            if(oper == '*') number.addFirst(first * second);
            if(oper == '-') number.addFirst(first - second);
            if(oper == '/') number.addFirst(first / second);
        }
        return number.poll();
    }

}
