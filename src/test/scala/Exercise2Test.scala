import org.scalatest.funsuite.AnyFunSuite

class Exercise2Test extends AnyFunSuite {
  test("swap flips tuple elements") {
    assert(Exercise2.swap((1, "a")) == ("a", 1))
  }

  test("swap works for same-type tuple") {
    assert(Exercise2.swap((true, false)) == (false, true))
  }
}
