package sample0410;

public class Display {
	//フィールド
	private static final int SIZE = 3;
	
	//プレイヤーのターン案内を表示するメソッド
	public void showTurnInfo(String player) {
		System.out.println("プレイヤー " + player + " の番です");
		System.out.println("配置したい場所を入力してください。");
		System.out.println("（上から順に0～2行目, 左から順に0～2列目）");
		System.out.println();

	}

	//結果表示メソッド
	public void showResult(String winner) {

		if (winner != null) {
			System.out.println("勝者は " + winner + " です！");
		} else {
			System.out.println("引き分けです！");
		}
	}
	
	//区切り・改行
	public void showNewLine() {
		System.out.println();
	}
	
	//盤面表示メソッド
	public void printBoard(Board board) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(" " + board.getCell(i, j) + " ");

				if (j < SIZE - 1) {
					System.out.print("|");
				}
			}
			showNewLine();

			if (i < SIZE - 1) {
				System.out.println("-----------");
			}
		}
	}
}
