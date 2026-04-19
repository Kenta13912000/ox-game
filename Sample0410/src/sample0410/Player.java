package sample0410;

//プレイヤーを表すenum型
public enum Player {
  // 各プレイヤーと表示用のマークを定義
  o("o"),
  x("x");

  // フィールド
  private final String mark;

  // コンストラクタ
  Player(String mark) {
    this.mark = mark;

  }

  // 表示用のマークのゲッターメソッド
  public String getmark() {
    return mark;
  }
}
