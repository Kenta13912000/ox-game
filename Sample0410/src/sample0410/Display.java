package sample0410;

/**
 * コンソール表示を担当するクラス
 */
public class Display {
	// フィールド
	private static final int SIZE = 3;

	/**
	 * プレイヤーのターン案内を表示するメソッド
	 * 
	 * @param player プレイヤー(o or x)
	 */
	public void showTurnInfo(Player player) {
		System.out.println("プレイヤー " + player.getmark() + " の番です");
		System.out.println("配置したい場所を入力してください。");
		System.out.println("（上から順に0～2行目, 左から順に0～2列目）");
		System.out.println();

	}

	/**
	 * 結果表示メソッド
	 * 
	 * @param winner 勝者(o or x)
	 */
	public void showResult(String winner) {

		if (winner != null) {
			System.out.println("勝者は " + winner + " です！");
		} else {
			System.out.println("引き分けです！");
		}
	}

	/**
	 * 区切り・改行メソッド
	 */
	public void showNewLine() {
		System.out.println();
	}

	/**
	 * 盤面表示メソッド
	 * 
	 * @param board 盤面情報
	 */
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

	/**
	 * 空白エラーメッセージ表示メソッド
	 * 指定したマスが埋まっていた場合に表示するメッセージ
	 */
	public void showErrorOfEmpty() {
		System.out.println("そのマスはすでに埋まっています。他のマスを指定してください。");
	}

	/**
	 * 範囲エラーメッセージ表示メソッド
	 * 入力した数値が範囲外だった場合に表示するメッセージ
	 */
	public void showErrorOfRange() {
		System.out.println("範囲外の数値です。0～2を入力してください。");
	}

	/**
	 * 数値エラーメッセージ表示メソッド
	 * 入力した文字が数値以外だった場合に表示するメッセージ
	 */
	public void showErrorOfNumber() {
		System.out.println("数値以外が入力されました。数値を入力してください。");
	}
}
