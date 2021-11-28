package doctacularsite.ascilite2021

import com.wbillingsley.veautiful.html.{<, ^}
import com.wbillingsley.veautiful.templates.{Challenge, DeckBuilder, VSlides}
import doctacularsite.{*, given}

val deck = DeckBuilder(1920, 1080)
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
  .markdownSlide("""
  |# The Jamstack?
  
  |Still writing...
  """.stripMargin)
  .markdownSlide("<img src='resources/ascilite2021/site-fixed-msg.png' width='1600' alt='A student fixed my bug' />").withClass("center")
  .willCcBy
  .renderSlides


