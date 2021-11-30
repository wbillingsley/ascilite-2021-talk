package doctacularsite

import com.wbillingsley.veautiful.html.{<, VHtmlNode, ^}
import com.wbillingsley.veautiful.templates.DeckBuilder
import Styles.*

/**
* A local object to demonstrate how layouts can be templated. These can be provided as libraries or written by
* local teams. The syntax will be cleaner with Scala 3
*/
extension (db:DeckBuilder) {

 /**
   * Two portrait images, side by side to fill a slide
   */
  def portraitImageSlide(image1:String, caption:String):DeckBuilder = {
    db.veautifulSlide(
      <.div(^.cls := imageSlide.className,
        <.img(^.src := image1),
        <("figcaption")(caption)
      )
    )
  }

  /**
   * A slide with a single image and a caption
   */
  def landscapeImageSlide(image:String, caption:String, cover:Boolean = true):DeckBuilder = {
    db.veautifulSlide(<.div(
      <.div(^.cls := (if (cover) s"${imageSlide.className} cover" else s"${imageSlide.className} contain"),
        <.img(^.src := image),
        <("figcaption")(caption)
      )
    ))
  }

  /**
   * Two portrait images, side by side to fill a slide
   */
  def ppImageSlide(image1:String, image2: String, caption:String, cover:Boolean = true):DeckBuilder = {
    db.veautifulSlide(
      <.div(^.cls := "wrapper",
        <.img(^.src := image1),
        <.img(^.src := image2),
        <("figcaption")(caption)
      )
    ).withClass(if (cover) "image-slide pp cover" else "image-slide pp contain")
  }

  /** A title slide for the front of the deck */
  def titleSlide(title:String, subtitle:String, authorCard:VHtmlNode, logos:VHtmlNode):DeckBuilder = {
    db.veautifulSlide(
      <.div(
        <.h1(^.attr("style") := "margin-bottom: 0; font-size: 60px", title),
        <.h2(^.attr("style") := "margin-bottom: 150px", subtitle),
        <.div(^.attr("style") := "display: inline-flex;",
          authorCard
        ),
        <.div(logos)
      )
    ).withClass("center middle")

  }

  def iframeSlide(url:String) = db.veautifulSlide(
    <("iframe")(^.attr("width") := "100%", ^.attr("height") := "100%", ^.src := url)
  )

  def sectionTitle(title:String, subtitle:String = ""):DeckBuilder = {
    db.veautifulSlide(<.div(
      <.h2(title),
      <.p(subtitle)
    )).withClass("center middle")
  }

  def willCcBy:DeckBuilder = {
      db.markdownSlide("""
      |<p>Written by Will Billingsley</p>
      |
      |<a rel="license" href="http://creativecommons.org/licenses/by/3.0/au/">
      |  <img alt="Creative Commons Licence" style="border-width:0" src="https://i.creativecommons.org/l/by/3.0/au/88x31.png" /></a><br />
      |  This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/3.0/au/">Creative Commons Attribution 3.0 Australia License</a>.
      |""".stripMargin).withClass("bottom")
  }


}





def bootStrapMediaBox(imageUrl:String, content:VHtmlNode) = {
  <.div(^.cls := "media",
    <.img(^.src := imageUrl, ^.cls := "mr-3", ^.attr("style") := "height: 150px"),
    <.div(^.cls := "media-body", ^.attr("style") := "text-align: left;", content)
  )
}

def uneLogo = <.img(
  ^.src := "resources/unelogo.png",
  ^.attr("style") := "position: absolute; bottom: 20px; left:910px; max-height: 150px;"
)