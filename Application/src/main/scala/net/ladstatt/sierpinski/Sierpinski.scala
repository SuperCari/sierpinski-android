package net.ladstatt.sierpinski

// TODO
// implement here all domain logic
// Pos / Triangle / Sierpinski


case class Pos(var x:Float, var y:Float)
case class Triangle(var a:Pos, var b:Pos, var c:Pos, var color:SColor,var counter:Int = 4) {
  var siblings: List[Triangle] = List.empty[Triangle]
  var centerT: Triangle = _
  if (counter == 0) {

  } else {
    counter -=1
    val top: Pos = Pos((a.x + b.x) / 2, (a.y + b.y) / 2)
    println(top)
    val left: Pos = Pos((a.x + c.x) / 2, (a.y + c.y) / 2)
    println(left)
    val right: Pos = Pos((b.x + c.x) / 2, (b.y + c.y) / 2)
    println(right)

    siblings = List(Triangle(a, top, left, SColor(1.0, 1.0, 1.0), counter), Triangle(top, b, right, SColor(1.0, 1.0, 1.0), counter), Triangle(left, right, c, SColor(1.0, 1.0, 1.0), counter))

    println(siblings)
    centerT = new Triangle(left, right, top, SColor(0, 0, 0),counter)
  }
}

object Triangle {
  def apply(a: Pos, length:Int) = new Triangle(a, Pos(length,0), Pos(length/2,(Math.sqrt(3) / 2).toFloat*length),SColor(1.0,1.0,1.0) )
}

case class SColor(var a:Double,var b:Double, var c:Double) {

}

object SColor {
  val White = SColor(1.0,1.0,1.0)
  val Black = SColor(0,0,0)
}

case class Sierpinski(var triangles:List[Triangle]){

}
object Sierpinski {
  def apply(triangle:Triangle, recursiveLevel:Int) =  {

    var triangleList:List[Triangle] = List()
    var fullTriangleList:List[Triangle] = List()

    for (i <- 0 to recursiveLevel ) {
      triangleList = List(triangle)
      val triangleSiblings:List[Triangle] = triangle.siblings
      fullTriangleList = triangle.siblings:::triangleList

    }
    println(fullTriangleList)
    new Sierpinski(fullTriangleList)

  }

}

