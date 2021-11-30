package doctacularsite.ascilite2021

import com.wbillingsley.veautiful.html.{<, ^}
import com.wbillingsley.veautiful.templates.{Challenge, DeckBuilder, VSlides}
import doctacularsite.{*, given}

val deck = DeckBuilder(1280, 720)
  .titleSlide(
    title="On the need for open teaching on the Jamstack",
    subtitle="",
    authorCard = <.div(
      <.div(^.attr("style") := "display: inline-block; margin-right: 50px;",
        bootStrapMediaBox(
          imageUrl = "resources/will sketchshot.png",
          content = markdown.Fixed(
            """<b>William Billingsley</b> <br />
              |University of New England, Australia <br />
              |wbilling@une.edu.au <br />
              |https://www.wbillingsley.com/ascilite-2020-talk/#/decks/uneSymposium2021/0
              |""".stripMargin
          )
        ),
      )
    ),
    logos = uneLogo
  )
  .markdownSlide("<img src='resources/ascilite2021/moodle-ends.png' width='800' alt='A student fixed my bug' />").withClass("center")
  .markdownSlide(s"""
  |# From an open source developer perspective...

  |* **Access will end** \t
  |  Why aren't we giving ex-students access to the latest version of our materials?

  |* **Save a copy** \t
  |  Are we still assuming everything is a powerpoint that can be downloaded?  \t
  |  But we're also reminded of *bit rot* as students lose access to services
  
  |* **This unit may not be monitored** \t
  |  Where does a past student go to "raise a bug" on our materials?
  """.stripMargin)
  .iframeSlide("https://docs.scala-lang.org/")
  .markdownSlide("""
  |# Open source documentation
  
  |Open source documentation is a form of educational material (content, tutorials, etc).
  |It is not university content (it is free content) but it is:

  |* Is constantly available
  |* Is designed for returning readers as well as new readers
  |* Is not tied to an LMS or enrolment
  |* Has a central point for contributing changes

  |It is typically [developed in a code-like manner](https://https://github.com/scala/docs.scala-lang).  
  """.stripMargin)
  .sectionTitle("Interlude", "If you were a robot stuck in a maze, how would you find the shortest path to the middle?")
  .sectionTitle("Interlude", "If you were a robot landing on the moon with a stuck thruster that can only turn off or on, how would you land safely?")
  .sectionTitle("Interlude", "What programming languages do GitHub users use in their projects?")
  .sectionTitle("What if we could develop like open source documentation", "(but make it a lot more interactive)")
  .markdownSlide(s"""
  |# The Jamstack
  
  |Originally:  \t
  |  **J**avaScript  \t
  |  **A**PIs  \t
  |  **M**arkup  \t

  |Now billed by programmers as "the new standard architecture for the web" (jamstack.org)...

  |(but also looks a lot like how academics wrote papers in the 1980s.)
  """.stripMargin)
  .portraitImageSlide("resources/ascilite2021/blogging-own-server.png", "Blog hosting in the early 2000s")
  .portraitImageSlide("resources/ascilite2021/jamstack-architecture.png", "Blog hosting on the Jamstack")
  .markdownSlide("""
  |# "Static" site generators
  |
  |* You write text files
  |* It compiles your content into a website
  |* You can put that website wherever you want

  |It started with blogging but became so successful that major corporate websites are buit the same
  |way.
  """)
  .portraitImageSlide("https://raw.githubusercontent.com/wbillingsley/ascilite-2020-talk/master/images/overleaf_smaller.png", "Writing a paper in LaTeX")
  .markdownSlide("""
  |# Education is a little different
  |
  |* Jumping from the notes to the video to the tutorial
  |* Wanting dozens or hundreds of interactive models, all different...

  |So what about a static site generator for education?
  """)
  .veautifulSlide(<.div(
    <.div(^.cls := Styles.imageCard.className,
      <("img")(^.src := "doctacular.svg"),
      <.p(
          "Doctacular! Doctacular!", <("br")(),
          "Teach 'em your vernacular!", <("br")(),
          "Instruction most oracular,", <("br")(),
          "To keep 'em coming backular."
      )
    ),
    <.p(<.a(^.href := "https://doctacular.com", "https://doctacular.com"))
  ))
  .markdownSlide("<img src='resources/ascilite2021/site-fixed-msg.png' width='1600' alt='A student fixed my bug' />").withClass("center")
  .willCcBy
  .renderSlides


