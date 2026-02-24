import scala.collection.mutable

def distinctPreserveOrder(xs: Seq[Int]): Seq[Int] =
    val seen = mutable.HashSet[Int]()
    val result = mutable.ArrayBuffer[Int]()
    for x <- xs do
        if !seen.contains(x) then
            seen += x
            result += x
    result.toSeq
