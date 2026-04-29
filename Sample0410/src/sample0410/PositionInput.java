package sample0410;

import java.util.Scanner;

/**
 * 配置する座標の入力・バリデーションを担当するクラス
 */
public class PositionInput {
	// フィールド
	private static final int MIN_INDEX = 0;
	private static final int MAX_INDEX = 2;
	private Scanner scanner = new Scanner(System.in);

	/**
	 * 配置する座標の入力・バリデーションメソッド
	 * 
	 * @param board   盤面オブジェクト
	 * @param display コンソール出力用オブジェクト
	 * @return 配置する座標情報を返す
	 */
	public Position inputPosition(Board board, Display display) {
		int row = -1;
		int column = -1;
		boolean isValid = false;

		do {
			// 入力受付(行)
			row = inputValue("行(0～2):", display);

			// 入力受付(列)
			column = inputValue("列(0～2):", display);

			// 空白チェック
			if (board.isEmpty(row, column)) {
				isValid = true;
			} else {
				display.showErrorOfEmpty();
			}

		} while (!isValid);

		return new Position(row, column);

	}

	/**
	 * 数値入力・範囲チェックメソッド
	 * 
	 * @param position 入力する数値の有効範囲を表すメッセージ
	 * @param display  コンソール表示用のインスタンス
	 * @return 範囲チェックを抜けたら入力された値を返す
	 */
	private int inputValue(String range, Display display) {
		int value = 0;
		boolean withinRange = false;

		do {
			value = inputNumber(range, display); // "行(0～2):" or "列(0～2):"
			if (value <= MAX_INDEX && value >= MIN_INDEX) {
				withinRange = true;
			} else {
				display.showErrorOfRange();
			}
		} while (!withinRange);

		return value;
	}

	/**
	 * 数値入力メソッド
	 * 
	 * @param range 入力する数値の有効範囲を表すメッセージ
	 * @return int型で入力された数値を返す
	 */
	private int inputNumber(String range, Display display) {
		boolean isNumber = false;
		String input;
		int number = 0;

		do {
			System.out.println(range); // "行(0～2):" or "列(0～2):"
			input = scanner.next();

			try {
				number = Integer.parseInt(input);
				isNumber = true; // 数値だったらtrue
			} catch (NumberFormatException e) {
				display.showErrorOfNumber();
			}
		} while (!isNumber);

		return number;
	}
}
