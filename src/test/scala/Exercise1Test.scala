import org.scalatest.funsuite.AnyFunSuite

class Exercise1Test extends AnyFunSuite {
  test("clamp within range returns x") {
    assert(Exercise1.clamp(5, 0, 10) == 5)
  }

  test("clamp below range returns lo") {
    assert(Exercise1.clamp(-1, 0, 10) == 0)
  }

  test("clamp above range returns hi") {
    assert(Exercise1.clamp(11, 0, 10) == 10)
  }
}
