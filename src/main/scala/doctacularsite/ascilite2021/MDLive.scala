package doctacularsite.ascilite2021

import com.wbillingsley.veautiful.{DiffComponent, DiffNode}
import com.wbillingsley.veautiful.html.{<, VHtmlComponent, ^, Styling}
import org.scalajs.dom.{Element, Node}
import com.wbillingsley.veautiful.html.{<, VHtmlComponent, ^, Styling, EventMethods}

import scala.collection.mutable

import doctacularsite.given

val mdlStyle = Styling("""
    |height: 80%;
    |width: 100%;
    |display: grid;
    |grid-template-columns: 1fr 1fr;
    |grid-column-gap: 50px;
    """.stripMargin).modifiedBy(
        " textarea" -> "width: 100%; height: 100%;"
    ).register()

case class MDLive() extends VHtmlComponent {

  var text:Option[String] = None

  def render = <.div(^.cls := mdlStyle.className,
      <("textarea")(^.on("input") ==> { (e) => text = e.inputValue; rerender() }),
      <.div(markdown.Updatable()(() => text.getOrElse("")))
  )

}