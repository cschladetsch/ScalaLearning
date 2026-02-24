import org.scalatest.funsuite.AnyFunSuite

class Exercise3Test extends AnyFunSuite {
  test("dupe duplicates each element") {
    assert(Exercise3.dupe(List(1, 2, 3)) == List(1, 1, 2, 2, 3, 3))
  }

  test("dupe on empty list is empty") {
    assert(Exercise3.dupe(List.empty[Int]) == List.empty[Int])
  }
}
