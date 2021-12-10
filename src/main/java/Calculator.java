import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    String[] operation = {"+", "-", "*", "/"};

    public int calculate(String input) {
        isBlank(input);
        NumbersAndOperation numbersAndOperation = splitNumbersOperation(validation(split(input)));
        Deque<Integer> number = numbersAndOperation.number;
        Queue<String> operations = numbersAndOperation.operation;
        while(number.size() > 1) {
            int first = number.pollFirst();
            int second = number.pollFirst();
            String oper = operations.poll();
            if(oper.equals(operation[0])) number.addFirst(plus(first, second));
            if(oper.equals(operation[1])) number.addFirst(minus(first, second));
            if(oper.equals(operation[2])) number.addFirst(multiply(first, second));
            if(oper.equals(operation[3])) number.addFirst(division(first, second));
        }
        return number.poll();
    }

    private Integer plus(int first, int second){
        return first + second;
    }

    private Integer minus(int first, int second){
        return first - second;
    }

    private Integer multiply(int first, int second){
        return first * second;
    }

    private Integer division(int first, int second){
        return first / second;
    }

    private void isBlank(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private String[] split(String input) {
        return input.split(" ");
    }

    private String[] validation(String[] input) {
        for (int i = 0; i < input.length; i++) {
            boolean flag;
            if(i % 2 == 0) {
                flag = false;
                for (int j = 0; j < operation.length; j++) {
                    if(input[i].equals(operation[j])) flag = true;
                 }
            } else {
                flag = true;
                for (int j = 0; j < operation.length; j++) {
                    if(input[i].equals(operation[j])) flag = false;
                }
            }
            if(flag) throw new IllegalArgumentException();
        }
        return input;
    }
    
    private NumbersAndOperation splitNumbersOperation(String input[]) {
        Deque<Integer> number = new ArrayDeque<>();
        Queue<String> operation = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            String now = input[i];
            if(i % 2 == 0) number.addLast(Integer.parseInt(now));
            else operation.add(now);
        }

        return new NumbersAndOperation(number, operation);
    }

    static class NumbersAndOperation {
        Deque<Integer> number;
        Queue<String> operation;

        public NumbersAndOperation(Deque<Integer> number, Queue<String> operation) {
            this.number = number;
            this.operation = operation;
        }
    }
}
