import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.baseball.Balls;
import domain.baseball.Result;
import domain.baseball.Validation;

public class Game {
	static Scanner sc = new Scanner(System.in);
	static String input;
	static String answer;
	static List<Integer> com;
	static List<Integer> user;

	public static void main(String[] args) {
		while (true) {
			while (true) {
				answer = sc.next();
				com = new ArrayList<>();
				for (int i = 0; i < answer.length(); i++) {
					com.add(Integer.parseInt(answer.substring(i, i + 1)));
				}
				boolean flag = true;
				if (!Validation.validLen(com)) {
					System.out.println("3자리아님");
					flag = false;
				}
				if (!Validation.validDuplicate(com)) {
					System.out.println("중복숫자있거나 숫자 범위 틀림");
					flag = false;
				}
				if (flag) {
					break;
				} 
			}
			
			while (true) {
				input = sc.next();
				user = new ArrayList<>();
				for (int i = 0; i < input.length(); i++) {
					user.add(Integer.parseInt(input.substring(i, i + 1)));
				}
				boolean flag = true;
				if (!Validation.validLen(user)) {
					System.out.println("3자리아님");
					flag = false;
				}
				if (!Validation.validDuplicate(user)) {
					System.out.println("중복숫자있거나 숫자 범위 틀림");
					flag = false;
				}
				if (flag) {
					break;
				} 
			}
			
			Balls balls = new Balls(com);
			Result result = balls.makeResult(user);
			System.out.println(result);
			if (result.strikeCount == 3) {
				System.out.println("다맞춤\n게임 다시할거면 1 아니면 2");
				if (sc.nextInt() == 2) {
					break;
				}
			}
			
		}
	}
}
