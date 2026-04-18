package sample0410;

public class Game {
	//フィールド
	private Board board = new Board();
	private Display display = new Display();
	private InputHandler inputHandler = new InputHandler();
	private String currentPlayer = "o";

	//ゲーム開始
	public void run() {
		//ゲーム開始から終了までループ
		gameLoop();

		//終了処理
		finish();

	}

	//ゲーム開始～終了までのループメソッド
	private void gameLoop() {
		while (!isGameOver()) {
			//入力～配置までの処理
			playTurn();

			//勝敗判定
			if (board.checkWin(currentPlayer)) {
				break;
			}

			//プレイヤー切り替え
			switchPlayer();

		}
	}

	//1ターン分のメソッド
	private void playTurn() {
		//現在のプレイヤーのターンを表示
		display.showTurnInfo(currentPlayer);

		//盤面表示
		display.printBoard(board);
		display.showNewLine();

		//入力受付・バリデーション
		Position pos = inputHandler.inputPosition(board);

		// 指定された位置に現在のプレイヤーのマークを配置
		board.placeMark(pos.getRow(), pos.getColumn(), currentPlayer);

	}

	//終了判定メソッド
	//勝者がいる、または空きマスがない場合にゲーム終了とする
	private boolean isGameOver() {
		return board.getWinner() != null || !board.hasEmptyCells();
	}

	//プレイヤー切り替えメソッド
	private void switchPlayer() {
		if (currentPlayer.equals("o")) {
			currentPlayer = "x";
		} else {
			currentPlayer = "o";
		}
	}

	//終了処理メソッド
	private void finish() {
		//終了後の盤面表示
		display.printBoard(board);

		//結果を表示
		display.showResult(board.getWinner());
	}
}
