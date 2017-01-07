package day1

case class Point(var x: Int, var y: Int, var direction: Char) {
  private val directions = Array[Char]('N', 'E', 'S', 'W')

  private def chDir(curr: Char, turn: Char) = {
    val delta = turn match {
      case 'L' => -1
      case 'R' => 1
      case _ => 0
    }
    val currentIndex = directions.indexOf(curr)
    val l = directions.length
    directions((((currentIndex + delta) % l) + l) % l)
  }

  def move(turn: Char, dist: Int) = {
    val newDir = chDir(direction, turn)
    val newX =
      if (newDir == 'W') x - dist
      else if (newDir == 'E') x + dist
      else x
    val newY =
      if (newDir == 'N') y + dist
      else if (newDir == 'S') y - dist
      else y

    Point(newX, newY, newDir)
  }

  def distance(that: Point) = Math.abs((that.x - x) + (that.y - y))
}
