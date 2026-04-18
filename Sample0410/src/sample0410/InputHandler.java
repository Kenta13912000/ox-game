package sample0410;

import java.util.Scanner;

public class InputHandler {
	//フィールド
	private Scanner scanner = new Scanner(System.in);
	
	//入力・バリデーションメソッド
	public Position inputPosition(Board board) {
		int row = -1;
		int column = -1;
		boolean isValid = false;

		while (!isValid) {
			//入力受付
			System.out.println("行(0～2):");
			row = scanner.nextInt();

			System.out.println("列(0～2):");
			column = scanner.nextInt();

			//範囲チェック
			if (row < 0 || row > 2 || column < 0 || column > 2) {
				System.out.println("範囲外の数値です。0～2を入力してください。");
				continue;
			}

			//すでにマークが置かれていないかチェック
			if (!board.isEmpty(row, column)) {
				System.out.println("そのマスはすでに埋まっています。他のマスを指定してください。");
				continue;
			}

			//OKならtrueにする
			isValid = true;
		}

		return new Position(row, column);

	}
}
