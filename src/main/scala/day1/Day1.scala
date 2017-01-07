package day1

object Day1 {

  def main(args: Array[String]) = {
    val input = io.Source.stdin.getLines().toList.head.split(",").map(_.trim)
    val start = Point(0, 0, 'N')
    val end = input.foldLeft(start)((a: Point, b: String) => a.move(b.head, b.tail.toInt))
    println(start.distance(end))
  }
}
