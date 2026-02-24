import org.scalatest.funsuite.AnyFunSuite

class Exercise4Test extends AnyFunSuite {
  test("distinctPreserveOrder keeps first occurrences") {
    assert(distinctPreserveOrder(Seq(3, 1, 3, 2, 1)) == Seq(3, 1, 2))
  }

  test("distinctPreserveOrder on empty seq is empty") {
    assert(distinctPreserveOrder(Seq.empty[Int]) == Seq.empty[Int])
  }
}
