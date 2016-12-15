package net.ladstatt.sierpinski

import android.content.Context
import android.graphics._
import android.util.{AttributeSet, SparseArray}
import android.view.{MotionEvent, View}


import scala.Option

/**
  * Implements a view which displays a sierpinski triangle.
  *
  * @param context
  * @param attrs
  */
class SierpinskiView(val context: Context, val attrs: AttributeSet) extends View(context, attrs) {


  val paint = new Paint()

  paint.setStrokeWidth(2)
  paint.setColor(Color.MAGENTA)

  def drawSierpinski(sierpinski: Sierpinski,canvas:Canvas,paint:Paint) {

    def drawTriangle(triangle:Triangle, canvas:Canvas, paint:Paint):Unit = {
      canvas.drawLine(triangle.a.x,triangle.a.y,triangle.b.x,triangle.b.y,paint)
      canvas.drawLine(triangle.a.x,triangle.a.y,triangle.c.x,triangle.c.y,paint)
      canvas.drawLine(triangle.b.x,triangle.b.y,triangle.c.x,triangle.c.y,paint)

      triangle.siblings.foreach(_.siblings.foreach(drawTriangle(_,canvas,paint)))

    }

    sierpinski.triangles.map(_.siblings).flatten.map(_.siblings).flatten.foreach(drawTriangle(_,canvas,paint))




  }

  override def onDraw(canvas:Canvas) {
    drawSierpinski(Sierpinski(Triangle(Pos(0, 0), 1080), 7), canvas, paint)



  }



}