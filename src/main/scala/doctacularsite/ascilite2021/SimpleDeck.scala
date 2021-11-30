package doctacularsite.ascilite2021

import com.wbillingsley.veautiful.templates.DeckBuilder
import doctacularsite.{*, given}

val simpleDeck = DeckBuilder(1920, 1080)
  .markdownSlide("# This is a title slide").withClass("center middle")
  .markdownSlide("""
  |# This is a content slide
  |
  |It's written in Markdown.
  |The pipe characters `|` are just there so we can write this
  |nicely indented into the code without Markdown complaining.
  |
  |(We just need to remember to call "stripMargin" to remove them)
  """.stripMargin)
  .markdownSlide("""
  |# Template slides
  |
  |The next two slides use templates, so we can have simple calls to show
  |fullscreen images and other common things we want to do.
  """.stripMargin)
  .landscapeImageSlide(
    "https://www.une.edu.au/__data/assets/image/0010/293248/Resizedd-Bool123.jpg",
    "Booloominbah"
  )
  .willCcBy
  .renderSlides