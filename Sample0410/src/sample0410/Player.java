package sample0410;

public enum Player {
  o("o"),
  x("x");

  private final String symbol;

  Player(String symbol) {
    this.symbol = symbol;

  }

  public String getSymbol() {
    return symbol;
  }
}
