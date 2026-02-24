object Exercise1 {
  // TODO: Implement clamp using expression-style Scala (no early returns).
  def clamp(x: Int, lo: Int, hi: Int): Int =
    if (x < lo) lo
    else if (x > hi) hi
    else x
}
