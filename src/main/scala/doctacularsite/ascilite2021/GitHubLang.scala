package doctacularsite.ascilite2021

import com.wbillingsley.veautiful.{DiffComponent, DiffNode}
import com.wbillingsley.veautiful.html.{<, VHtmlComponent, ^, Styling, EventMethods}
import org.scalajs.dom.ext.Ajax
import scala.scalajs.js

import scala.collection.mutable
import scala.concurrent.Future
import scala.util.{Try, Success, Failure}

import doctacularsite.given

val ghStyle = Styling("""
    |width: 750px;
    """.stripMargin).modifiedBy(
    ).register()

case class GitHubLanguage() extends VHtmlComponent {


  var proj:Option[String] = None

  var results:Future[Option[js.Dictionary[Int]]] = Future.successful(None)

  def lookup(r:String) = {
    import scala.concurrent.ExecutionContext.Implicits.global
    import js.Thenable.Implicits._

    val url = s"https://api.github.com/repos/$r/languages"

    results = for 
      response <- Ajax.get(url)
      json = js.JSON.parse(response.responseText)
    yield Some(json.asInstanceOf[js.Dictionary[Int]])

    results.onComplete((_) => rerender())
    rerender()
  }

  def render = <.div(^.cls := ghStyle.className,
      <.div(^.cls := "input-group input-group-lg",
        <.input(^.attr("type") := "text", ^.cls := "form-control",
          ^.attr("placeholder") := "owner/repo",
          ^.prop("value") := proj.getOrElse(""),
          ^.on("change") ==> { e => proj = e.inputValue }
        ),
        <.span(^.cls := "input-group-append",
          <.button(^.cls := "btn btn-primary", "Lookup",
            ^.onClick --> {
              for { t <- proj } {
                lookup(t)
              }
            }
          )
        ),
      ),

      results.value match {
          case Some(Success(Some(data))) => 
            <("table")({
                val sum = (for (lang, bytes) <- data yield bytes).sum

                for (lang, bytes) <- data yield
                  <.tr(
                      <.th(lang), <.td(s"$bytes bytes"), <.td(s"${(100L * bytes) / sum}%")
                  )
            }, ^.cls := "table")
            
          case Some(Success(None)) => <.p()
          case Some(Failure(x)) => <.p("Failed: " + x.getMessage)
          case _ => <.p("Looking it up...")
      }
  )


}
