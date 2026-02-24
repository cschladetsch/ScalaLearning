object Exercise2 {
  def swap[A, B](t: (A, B)): (B, A) =
    (t._2, t._1)
}
