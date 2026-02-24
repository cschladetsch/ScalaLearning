object Exercise3 {
  def dupe[T](list: List[T]): List[T] =
    for
      x <- list
      y <- List(x, x)
    yield y
}

