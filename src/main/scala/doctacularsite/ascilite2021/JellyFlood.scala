package doctacularsite.ascilite2021

import com.wbillingsley.veautiful.{DiffComponent, DiffNode}
import com.wbillingsley.veautiful.html.{<, VHtmlComponent, ^, Styling}
import org.scalajs.dom.{Element, Node}

import scala.collection.mutable

import doctacularsite.given

val jellyStyle = Styling("""
    """).modifiedBy(
        " .jelly-row" -> "display: grid; grid-template-columns: repeat(auto-fit, 60px);",
        " .jelly-cell" -> "width: 60px; height: 60px; border: 1px solid lightgray;",
        " .lava" -> "background-color: darkred; width: 100%; height: 100%;",
        " .jelly.active" -> "animation: pulse-jelly 2s infinite;",
        " .jelly" -> "background-color: darkgreen; width: 100%; height: 100%; border-radius: 10px; color: white; text-align: center; line-height: 60px;",
        " .floor" -> "background-color: #242424; width: 100%; height: 100%;"
    ).register()

case class JellyFlood(w:Int=8, h:Int=8, goalX:Int = 7, goalY:Int = 7, mazeString:Option[String] = None) extends VHtmlComponent {

  val maze = mutable.Map.empty[(Int, Int), Boolean]
  val distance = mutable.Map.empty[(Int, Int), Int]
  var tick = 0

  def setSquare(x:Int, y:Int, c:Char):Unit = c match {
    case '.' => maze((x, y)) = true
    case '#' => maze((x, y)) = false
    case _ => // do nothing
  }

  def loadFromString(s:String) = {
    for {
      (line, y) <- s.linesIterator.zipWithIndex if y < h
      (char, x) <- line.zipWithIndex if x < w
    } {
      setSquare(x, y, char)
    }
  }


  private def check(p:(Int, Int), dist:Int):Unit = {
    distance(p) = dist
    val (x, y) = p

    for {
      (dx, dy) <- Seq((x+1, y), (x-1, y), (x, y+1), (x, y-1)) if (
        distance.getOrElse((dx, dy), Int.MaxValue) > dist + 1 &&
          maze.getOrElse(p, false)
        )
    } check((dx, dy), dist + 1)
  }

  def resetMaze(): Unit = {
    maze.clear()
    mazeString match {
      case Some(s) =>
        loadFromString(s)
      case _ =>
        for { x <- 0 to 1; y <- 0 to 1 } {
          maze((x,y)) = true
          maze((w - x - 1, h - y - 1)) = true
        }
        for { i <- 0 until 8 } {
          maze(4 -> i) = true
          maze(6 -> i) = true
          maze(i -> 4) = true
          maze(i -> 1) = true
        }
    }
    resetDistances()
  }

  def resetDistances(): Unit = {
    distance.clear()
    
    check((goalX, goalY), 0)
  }

  resetMaze()

  override protected def render: DiffNode[Element, Node] = <.div(
    <.div(^.cls := jellyStyle.className,
      for {
        y <- 0 until h
      } yield <.div(^.cls := "jelly-row",
        for {
          x <- 0 until w
        } yield {
          val d =  distance.getOrElse(x -> y, Int.MaxValue)

          <.div(^.cls := "jelly-cell",
            if (maze.getOrElse(x -> y, false)) {
              if (tick > d) <.div(^.cls := "jelly", d.toString, ^.onClick --> {})
              else if (tick == d) <.div(^.cls := "jelly active", d.toString, ^.onClick --> {})
              else <.div(^.cls := "floor", ^.onClick --> { maze((x, y)) = false; resetDistances(); rerender() })
            } else <.div(^.cls := "lava", ^.onClick --> { maze((x, y)) = true; resetDistances(); rerender() })
          )
        }
      )
    ),
    <.div(^.cls := "btn-group",
      <.button(^.cls := "btn btn-outline-secondary", ^.onClick --> { tick = 0; rerender() }, "Reset"),
      <.button(^.cls := "btn btn-outline-secondary", ^.onClick --> { tick = 0; resetMaze(); rerender() }, "Reboot maze"),
      <.button(^.cls := "btn btn-outline-primary", ^.onClick --> {
        tick = tick + 1
        rerender()
      }, "Step")
    )
  )
}