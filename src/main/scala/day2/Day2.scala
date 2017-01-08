package day2

object Day2 extends App {
  val keypad = Array(
    Array(1, 2, 3),
    Array(4, 5, 6),
    Array(7, 8, 9)
  )

  val directions = Map(
    'L' -> (0, -1),
    'R' -> (0, 1),
    'U' -> (-1, 0),
    'D' -> (1, 0)
  )

  def loop(pos: (Int, Int), instructions: String): (Int, Int) = {
    if (instructions.length == 0) (pos._1, pos._2)
    else loop((
      Math.max(0, Math.min(pos._1 + directions(instructions.head)._1, 2)),
      Math.max(0, Math.min(pos._2 + directions(instructions.head)._2, 2))
    ), instructions.tail)
  }

  val lines = io.Source.stdin.getLines().toList
    .scanLeft((1, 1))(loop)
    .tail
    .map(k => keypad(k._1)(k._2))
    .mkString

  println(lines)
}
