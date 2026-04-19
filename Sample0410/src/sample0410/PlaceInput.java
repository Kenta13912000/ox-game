package sample0410;

import java.util.Scanner;

//入力・バリデーションを担当するクラス→クラス名改善
public class PlaceInput {
	// フィールド→マジックナンバー解消
	private static final int minLength = 0;
	private static final int maxLength = 2;
	private Scanner scanner = new Scanner(System.in);

	// 入力・バリデーションメソッド→close
	public Position inputPosition(Board board) {
		int row;
		int column;
		boolean isValid = false;

		do {
			// 入力受付
			System.out.println("行(0～2):");
			row = scanner.nextInt();

			System.out.println("列(0～2):");
			column = scanner.nextInt();

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
}
