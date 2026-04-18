package sample0410;

//ゲームの実行・進行を行うクラス
public class Game {
	//フィールド
	private Board board = new Board();
	private Display display = new Display();
	private InputHandler inputHandler = new InputHandler();	//ネーミング（他のメソッドも）
	private String currentPlayer = "o";		//識別と表示を分ける

	//ゲーム開始
	public void run() {
		//初期化処理
		
		
		//メイン処理(ループ)
		gameLoop();

		//終了処理
		finish();

	}

	//ゲーム開始～終了までのループメソッド(名前変更→ループを外す)　※名前をいろんな観点からよく考える
	private void gameLoop() {
		while (!isGameOver()) {
			//画面表示をやっているかがわかりにくい
			
			//入力～配置までの処理(1～3)
			playTurn();

			//勝敗判定(4)→継続条件とまとめる
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
