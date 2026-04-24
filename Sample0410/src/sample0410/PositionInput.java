package sample0410;

import java.util.Scanner;

//入力・バリデーションを担当するクラス→クラス名改善
public class PositionInput {
	// フィールド→マジックナンバー解消
	private static final int minLength = 0;
	private static final int maxLength = 2;
	private Scanner scanner = new Scanner(System.in);

	// 入力・バリデーションメソッド→close
	public Position inputPosition(Board board) {
		int row = -1;
		int column = -1;
		boolean isValid = false;

		do {
			// 入力受付
			row = checkNumber("行(0～2):");

			column = checkNumber("列(0～2):");

			// 範囲チェック→continue文削除
			if (row < minLength || row > maxLength || column < minLength || column > maxLength) {
				System.out.println("範囲外の数値です。0～2を入力してください。");

				// 空白チェック→continue文削除・else ifで処理
			} else if (!board.isEmpty(row, column)) {
				System.out.println("そのマスはすでに埋まっています。他のマスを指定してください。");

			} else {
				// OKならtrueにする
				isValid = true;
			}
		} while (!isValid);

		return new Position(row, column);

	}

	// 数値チェックメソッド
	private int checkNumber(String position) {
		boolean isNumber = false;
		String input;
		int number = 0;

		do {
			System.out.println(position); // "行(0～2):" or "列(0～2):"
			input = scanner.next();

			try {
				number = Integer.parseInt(input);
				isNumber = true; // 数値だったらtrue
			} catch (NumberFormatException e) {
				System.out.println("数値以外が入力されました。数値を入力してください。");
			}
		} while (!isNumber);

		return number;
	}
}
