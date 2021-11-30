package doctacularsite.ascilite2021

import com.wbillingsley.veautiful.html.{<, ^}
import com.wbillingsley.veautiful.templates.{Challenge, DeckBuilder, VSlides}
import doctacularsite.{*, given}


val lander = new canvasland.LunarLanderSim("lander", lz = (0, 640, 420))(onReset = { sim =>
  sim.world.gravity.y = 0.16
  sim.Lander.setPosition(1000, 500)
})

val talk = DeckBuilder(1920, 1080)
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
              |https://www.wbillingsley.com/ascilite-2021-talk/#/decks/ascilite2021/0
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
  .markdownSlide(s"""
  |# The Jamstack
  
  |Originally:  \t
  |*  **J**avaScript  \t
  |*  **A**PIs  \t
  |*  **M**arkup  \t

  |Now billed by some programmers as "the new standard architecture for the web" (jamstack.org)...

  |...but it (sort of) all started with blogging software
  """.stripMargin)
  .markdownSlide("""
  |# Blog hosting in the early 2000s
  |
  |![Blog hosting diagram](resources/ascilite2021/blogging-own-server.png)
  |
  |Too much to maintain - everything in the red box could get hacked.
  |
  |But if you use an online blog hosting company, your content is trapped in their system
  """.stripMargin)
  .markdownSlide("""
  |# "Static" site generators
  |
  |* You write text files, typically in "Markdown" format
  |* It compiles your content into HTML and JavaScript files
  |* You can put those files on any webhost you want (e.g. GitHub Pages)

  |Jekyll (by Tom Preston-Werner, GitHub co-founder) was the first, but there are a few now...

  |![Jekyll](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAATsAAACgCAMAAABE1DvBAAAAyVBMVEX///8AAADMAADJAADz8/Pq6uru7u77+/v4+PjJycn29vbh4eHa2trV1dWbm5vn5+e4uLhEREQ9PT3Dw8POzs43NzeVlZWioqJbW1tqamqPj49/f3+GhoYiIiJzc3NhYWGtra1OTk4NDQ0ZGRknJycuLi6xsbFvb295eXlKSkpAQEAjIyMTExP77e344uL009PssrLPFxfRLCzffX3ca2voo6Pxx8fllpbUQ0Prrq7ddHTiiorZXl7XVVXcbGzTNDTWTU3119fPISGdYdXxAAAP60lEQVR4nO1diXbauhZFATwwzzZDwGbKUNKmUzqkfX33/v9HPU1Hkm2ZYDBx6NNed60GDNg6OuPWkW6pZGBgYGBgYGBgYGBgYGBgYGBgYGBgYGBgYGBg8H+Ottt3G7Win+IS4a4RxcpvDYp+lgtDHakYd5yiH+iC0EKoUalVqs1gzBRw3iz6kS4GW4TE322vS6TX6xT4PJeEJkLYTK3Z4tZzK1h8o2vi+7ZFP9ZFAPu7aqnkMXfXbeG/+3f4r41b9INdALDsGvifIUSLsF8qDUISNkzUeAlM70qlsYi1a+zu+sRyTdB4AS7Eiv5KSK9XL5Um+F/j9fZjjjbwZ3AtpBdgw8X/mIC7Dw5CLfnKXYDwsNSq+J9KcU/29rGNycfp3LACo0RdYSvlawYY92iReM8auLSybSA0e/UHuhxg1UpN5HAUoemLgR4ztEy7RETXf81nuTQs0STlCjZYZDipPegj1NZfwfE33ZoNMHx0l3JlajLj/bBSBWQj5L/us1waWpR/0mF7sRZrt/t91zr/fdboNuXKncKIXhDszmJJU/u7c/MYg1SqpI1S4+8bhtNaypWXM6dXN2iYcmWSGn/fMILIqlWaN8oHFYS8lEs7FJ7zzudAuxsVXerYcgGepxSf2r889immdBhprjwX6GgAhgVC9jnvnD9uI2LrzrESpg0uDzRS/SlO+6ZnvPEZcKdKbkSs6f6sQ5ihVcoV78L4E2etSG7GLMbPXBZV+rNwtfODQz6bnoZsUuPvm0RFyUw2df5mqi/XwwmE6h6grx2E6vorzTPHqJyhik5og5cpUWir7nKnub6d+uFYCiWdBri9qGUKVXSCM6tkWSC1/EigidtcfbLjV9b8nWpqGuKwxYoLgbUTg95IKw0zRNkR2njXiuyiywydnnKpCd/4K2iAmhSdwvuMMljOpOdGU5yqcnEb0UiIoNd7aIC0+Pv2YG/EuOby3eypvfwZVe0aazQPVdmxt9NpgDpOkLLduEB0dUNuZiYylP7NjXy3gSYVMg8CfMF1rH4ogtkF0QCyh0YRVj27v5a/o+YeNskUvYTa1f4KGmCWIrqs1VhTiidh6/fyGo8C3t9AAwQ60TWPyBJkWZLwVm7SEQ7/AhqgmRhViU595jq2pYs3HDKIgDU2UtOQy6EBZE6sjNg7oiSqCvEkV7ekWNeQ0U11hQd1jq2LoQFCzYhvj0lNxQ8NEwZnSYsV8TMliD8THe1lvnkhGMGguuIta4h61T1f0UN4zVVyZ5Ms1kRCl0IDfPlaIA1Qz5YYDWBQ16I66h/VtVUR4kmKvSOuSaIz1NIAP8u10rwgGiBYokypkbNMjPj2uKUxoVpJbaoJ0QXiPT0N8Lv8n8JoANZtmkHjRTILttRcocUxuwm38R/S3URp4Bxp0pCHT+XyE7H9IlqfeCV++LSJQgm44dnhWakzGEjTEsFAE2LETVRPoFlCeixfXX0k5eG7g58/P0CidnAZ7cRGhRPY8aFJaRCxwbvYHCiw4SbqlLoJBf3wHYuu/K0oGgAIoIOToxv+BeYhqz5aH2wtnYiXhGJV5y38yE04FoL/pHj/9ROWHJbdQ1E0AN9SdHPo5yHGroiuVW5VV/4SwEbZMIE+0YVniLH36psqDfDh65erMpXc1dVvYsyF0ADMJ6etACQBJG+dSS5LK36I0GY0mXHvtkn3s5C6rCO+wIM05P1nITeidk+F0QDVZRZnJ+ok4qOmyMtSfUeZvSn7na7uk0AMRhmTd4wGePiiCI6AWniG58gTjcbhEgCNOKZl4k51DH3F8uOA+YkmfU0Wj5+uopIrP18KDTBno+KrWYPRwvfnB5pLU1WOilY8DOAIY5nLLf3+16jksOzeXwgNAMMi3t6aQHmxiknA6owmXmI0CxTIF6G0/ATeacOvTT1LQnRXf4gLLoAGCOYZCyk5ZHuCFKiWV+e74vxopeGqatdKjxOg2vFrWzJjjwnRlX+QyB9kG0YeaKUx5BWrXbeStfVADGuwUkWHAvkZXDcNb1eKYTPU1GRksMfZ8fTkOv5+F4eVh4Torso2STiLOF5GtxehHSx4+jCcxRLOexgyUbr5ti9WpYVY7AUlBUYJi1wovq3GjV23VghcaNwR1kka8q18VX50IrKjNMDByWmeaMWbGJxAWV5BsfStD0PGOYFH2Seb+ybIPZwhCom6suV8hRf11Bv50S9F0EsoMsOEmDwpwJ4fI2r3oSgagD6p8tJuKWJbJnRnyIe8QT5kXryu4qHWesc0kPtCuZBKtngJ38+varu9eNaX5N9JGvJETDaa3H0kT1VINwDlAaRddmRjjt/BLqTRjaw2My81rKyUEMhVkfkba8VEDdSSqJNsYtvV6Fe06QnUYomGkz5JQ74kvd23wrYZUyIDkglHctw97okImyEjBsv2B9eqiTC9Y5mytWNXBKssjHIxlGoGaY5uwG1+LRn9fTyJtiZSUBrgFfbCJOCp89+QSicrtLFiD4ysmvUiCjOUamct2ZW2+B2IBa37UMgK4oQ2I0stcS1i8j9U2bG/KQ1QxPaxhmofSueHks/3lCVEqpbDMLKy0JFqYqEdnX9HdISBprkokFMEJ8HoCgE4LiGZunhkfj4povvy9P2K0gCdQrYZAyNEXyiiU/KSgfKKiWkTWVFhKuaxX3vHJiGMz0EVkaOGOPMGV3X1JzRpaGSxxrr4j6p2duk9eUl/8HgRHIvauyXNB6jGKz0hiuicpYwKXEkjoqurouNaJrtUwJR2U9IawXwfaNZSkxUDFarJ1gdkIj4rssMKR3I9SgO8/qEKtWvENIkMSi71qc4M+37xXPAJVXSB1K4qxFS5MAgfDYclccoQ9vjsmoY+6CDNLTjm5GyAaJAgDo/RACl92+cDtjbeIk1Co2ykU+ylo5bjvaQ9U891Qw21Ae5ddkiAeG6RQ2RMQ46PuGvQkHZCdEHymkPCV7KUvfpOTg149U0BVXRt8WShpPamylS/2aVnK3HEvbizpZKbM1m6wn3JSeDCbOGgQF7OaM3R4Ll3shgLEA8xOlGMyaT9N5mg/CAEw6vvb3dmDq+MSBwVA4bEobbdoI1iV7eIkxshEVYzoF8NA7CuFeRqstWQpzYdrH4TLi0iAHYx6dEmaL5IEyt50JDTANGiwiZSLaJvjPe2uWonHUkc7KYX4mxXLRHHqD+Fj9BuuV046mvcktJ8U+f3aLE3SZR1bbhnIj8Zo5tqmljtO8RpgKvyl3+evkvp/STkTLLx7BXAvPaupHS5zUsNYop+Kzr5C+wThVCaJctK2xt7Iz4V0NdNYqpUY3m2zTxsPJet9LDN8/icWCm0NigkyvWRJHXkjT/CZCkNUMRJd9y8Wmod0CbEXZwKww9fV9O/9IeVP8S0p06UoqGKhF2NsR5N6g2XfPZiIGcrrjkNgIWF8Q0U71NRNACYV0UxWW1tM0BriykP7KVITeMlCcODLxEhLZl5AsPsch39VkAncKBXOzxndRdoAJzUYTxz2ZW/knkpggbgnTIkPgpXpluzaaGQOOMVTmdFK39a108IH6DSHVDRddRfZgKKrGc6CxYpJ4q+SozwXXGoGJYeICfhfzEaYFpI3xg0QZPaVGwhTNIReGSUImlQMYsUTH8WqWghoevkHWp/NjNF/olOwuhdeB1qrNnx0XWVKKtHl3jwf5++PYtI8augU2TsnVQ7UZ0nVgjIyJiOBWxcIgXZ6XpjRXFC1G7KShIWASBr3MamqIKDyz17Sa9EnVdzhboO9QQVEiD+PH5Xc5TCaAAwU/rcEGYTrNBUKMIN1x1ZcS0Uz9QI6D9CdvTwUvpeParQzGaF0pKpgKKPXolEignPrzkNUP4nutLzsSAaAMhJ5nmgSTDmw90dW3ogGIIraovDhNFUSM/n+RoEk801GGY3KhJHsVmLnKayEkZKryglQnPDdR5ogPIjo9xB7Z4LOkWGrw9yExGWqPq76kKJCaRHFl4ou5T8DnGX9TugKkXQAYfII7hUUZrrrfr1AUm/I0MXxk5BjHnJZHyDfYlNpfVH0TpCA4yK6BuDjjv+qMLW5FAsLIaufDCSWwgNsT1laXZ5ra4v8mp2OIj8sGqJ6tECU3Wu6Fc9eXc0Z7VWLZ0GWGVo3soLkOeKhEDkZQF7PSBWrCYsbRRdfWnOhOmuZhEa+ebOn4k4GsbVriTWyFDPi2YXNIwssdDrAfnaCoJR8KZoAKFmctpFLbWZeKOxogEcRHbxn2m4/b7b3HdyEbfYOEPc7ARbN5mWRXa+q9xXyBjiGJxCaABYuw6U96LH6tzFk+R2ytLMXkDlcmi7g+hvCZXbN4AGiOEnUYGzHv2z7xFjWWXA53013yZT5OoxSWjaAn863NFs1upHZD0FGiBmsh9IzHptGkAU9Umrsdrt9NNHM8uOz5G2rfNwiG6AKCgNkLZ9+1wQnHi2hNzPbLOQQp62mNAhNMCvpNpRGuCVt49BLZZ1bWmQNYOHDU0n0hyhoAFEbkIL2iJoACj7MydG44xNqb0j7xNFlbjLSKcnri4+ERrAOe9BZxqILVrZp6ybyeHNE2nQURhxGkDBv7+ABnjdU2REzXRMY/NNhmQK6rZTh7eKdwMwUBrgdQljsV/43Ok4sC2ncrpuvBuA2+3r0wCi8jr3pjUIsSevYI2BBojJ7n1+h8lWD3JFQuuOH9JhW2ShceVkSreSTgNc57V9zDkkfxAVzwnhaX1IUgirGicmxSXqNas6GuCRGHNe28d2L49JhIlTNobPDsgKQXTJUycyw0+lARb5HZ88eVGXxP9D6aRtV+7LCg6+rpsDxUGCTXIbT/knYRlyowEaL3AVFXEA34llzIuVHETYPJavbFI4auqxnGmAzV7/L/sST823Zi8kVaM8tBtQJXno74TsKA2QY9+Yuy/bFQsM3ZMLwMp+xQXPkE/+aBGeP6F3+dMAYSqFWgtBdHl0H7T2TBL0ycc3NR4NMgnPcX9Xfsj7MFk7tjtcQCyo9vIZ0VBzfg4D9Bnntwl4qOPuaDdAvjRAnXbcJN4V7RJ5lWHOSu+m+1zp1jlyufTIsX9javd0hsNk68l00QI2I88qzFlrfs2FQJ4rHTkgQ4op3vez9I05Puqp8zGQZwLlu7l0jlaRWaoF0JTRynndakhaZKJcwAPxQmcoyPtD7G06Ddsu1TtT2OAU5n/2RfMe56Z96vcqbgtiUTf/G7nUe0rhlcvvSfTVHh54MppT5YRwIrgg+4F0h90HRXHnnaW7YUyzg6d/SfdTuVz+bJdq6zOSnu2+N134vj8ebTOc3JEd9e1o3O1thj1/5jXOtnKwYXH76duv359/PLA8yPx/ZQ9DDQtPsje0T+UC/wdaBcEmEe96unWbfdY6dSknGL8J9JXD3tG8iF3Gl4zBLe26WobeeSLfX45apVK5kDOzDQwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAxK/wOmJ9dql1SapgAAAABJRU5ErkJggg==)
  |![Hugo](data:image/png;base64,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)
  |![Gatsby](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPsAAADJCAMAAADSHrQyAAAAllBMVEX///9mM5ljLpdjLZdeI5RhKpb49fpfJpVdIZS+r9FfJZViK5f28vmGY6z+/f+EXa3j2uxaG5LOv93v6vSkicHWyuN9VqdYFpFuPp5qN5zx7Pa4o87h2Ovn4O/d0+jZzuV6UKawmcltPZ6TdbW+q9KNbLGbfbt5TaXHt9mxmspUB4+6p9COa7SbgLpyRqHLvNysksdLAIoOQe8BAAAOt0lEQVR4nO1da3uqvBLVBAgCKohc1OIVlVZF3///504CChMuVm2tcR/Wl70r4sMiyZrJZDJptRo0aNCgQYMGDRo0aNCgwQ1QDHu6WwwPq3W3u14dTovowzCUVz/V86E4u0PXVy2JyLKuY6zLskxUj8TrU/jx6od7IsbTRb+tazJG7RKQTggerUPTePVTPgPT01wjuMwaQpf07sR+9ZP+Mj4msUUqmrsMrFn9zj9E/2Mzuo34mT6JT/8I+9lKI7cTT4DI6BS8+rl/DrOL5TuZJ5DR8M3Z9yajh5gzkHjw6sf/CRxffZQ5BfK65qsZPApj075D4aqgj3a9V7N4CM72W4n79tUgqT9+NY/7oUza9Y4M9eJUPBr5sT/SVZXoV96BHB9fTeVeGCuphrYsWV/L/WIwm36YgTmdOdHnKvY8+gbq3tPi1WTuQ9CulndZ3R5Cp2IMB4PPvS6hyg6gdt/J05nFVf0dk+VqYNeKl2JOXGrWK27U5+9DfmBVMNC9fvitbpmLpVp1rz/7i+f+Bewq+rveXld19TLGoVvR8/HIefZT/wrCsmnDVv825gyKE5fbHo3ewcONvNJzE3d610/0Jn6p62BffPJOqdHl0e7uYIy9L9l8fS56SC8oDVZpXa1whm1OHWdqBtWXB6VJEFmLTX7sFowb0nelJ1bGs0XXnVOnDqHRMt72D2FglOTA7JfIb/6GxGPorbRCRx2V5qHOYj+yCMaXDoIQllXVPxyL7W8Mi8qhhn/E4xFMCk0lzwsCZXe2pDJgiWQi7wcFXfgsjXlxzfy04JITlydjn7balWmLTvohP0BCq/ANV9RZnR3zxEiXG8TKSbvGnAGreMKxjwp3kP3fUroZB77H61uO+qB/S8QSyS7XrweFrqSKOaP94ONT+ha2oH2QvlmXyNqebOBI+fji381cxIUbpcs1ERrBh3T8O8LUxIduYMS/MzL8a2I3IOLMG5KhcRtUT8xrm769Azcv+P6ExPNtbZ+jh6P8Uu/E99sb4MHWXXEdSl4LF76ccJ0a9kxlfe+yDIUGAlWBz10iohl5hWt25Oc6p3RrInfXQSbZD6z4ES+vXsKwHiE/KMFgXz+4MCOdyZsl2zi6b0b8bBh92DbkkF/5LLhmtyOVjGBZeneyWFLPizzOQ4vhDxalLJv5NhUWQhUqdMlNXckp+/xj9INVKdw1wsqlG/L5QqpFmLBjozibcChuzYLDbSB7rfJz5Ark3HEGTssUurV4SOJz1LnBujhRW8MFPRMts9E4/Rnzeghk5hwoaPlg5G3+r0ISptNvoBmSs2YvRh5+k3t07Xn+EAqMWcjry8fcSPhlyAdBnPrpCDxVLkODHwrdNaCtIMGrDlB5YH72P7Jv30AVIxOntwYkSTb/mj6vx7f5ed4L0YMkrWwWc/pJitW3wN1XUs4wg3LuZZPX3uqZ5JEvxIAPgaahOP/c2DyTvBgT2aFc80i97hPJ60IkXXLhNAQX4JQntrzUeR3jDEafE3TUBi2vrJ9m44UIYASFlSgEJ1nPEzzcF8CzK03W0BKQNzZPanm0FID7rOS+If0vBA8LkIUxKzcsghlhzxI8VQDuTgU1hMFeN2X/lG7vCcD9WNWsfyB4ngDB2rCyVdESrBwZxTScehDpGqBF8QRYk5xAXsvs6XjBW9/Y8qNF5xrmgLwlgFML2x1v8lgNZ+puFbxvkifh6o8I7Q7Hu3wKcGbykA7iC8ptps6/HpKAUTARxjvUeXnTMrdZ2zwgeN9w30LuAug8tO/6utUywZi/W/C+4Q6D3iLYd+jXJdGUjxh0e0D+FsH7hjt8eyL4dTAul2ZBwW5/p+Bd526AJFMh/Hk4j0OpTpujnDy5S/Cuc4dLnkLM4/j5e9rHzXlOHt8jeP5UKSPLsR6Au8XINYNxG+0ctQlAy8MwlrG+LnijfreEfpZw9gkWAoSI23Dxuiw8b24fEzyEi9BlJ7sXvGUx4nVcnNa9fFoneHdHb/OcrQCadzHitDOY4m9llsdcgpaHU9o7gxn5WjtMURckPl+zLtMKgOC1H5/SStkvDsFwF2RdhhM7kGf0sOBxACuuMCiqCZJuFGrwUcEUI9hmMni3h5c1e5a9M4NJPZIY67B8pJZA/Q3yPcHI53z7m8NYatbsC7jUPRdiuBfyLnRuV0fgg5YHgte7Nck23xdmwMCFfGgJgpp8GwYoeFz09jbBQ8usb0OnTpx8m0Ke1YS7FrRzUzcCLW/U5A3ykHLp5F6wJkyeFZ9fF/PPFcwfFzw8zyYswRJ8Lgu0Q5LLqyz2xx8IHs6Fk9uEhQXaPsDl05Zml0H8oOCpefqkCTuJUPm0fB61XhSiYJ6PeS6Ycb3l9X1GsbfiRrsgjk2KCHZ6tCw2CxS8NhfMuCZ4X/nPHLmsYkmAEG0Opcsl0JfiCoELuv1tvj1C+aBWuDR8IdIOAPj9EaNS2U1O8KBvXxu9lcAeuQW3ZUaM6WsOPmcax6UgKufb3yB40E1wuMwOgRLIz+C3vpNyrm/gVgtetanTQasXslpkgQxcijH/gKTsdNp5BQuEOMErkUcedA45jafNLkCAtoAjvx8Wl7d12LcKnu7DyeCCT8PHQol8CoXPmwazkAw2WLHx64MZZAuXWMPCPuhT6WcFQGn/e3mKbUPfnktIyru9rm2gUM7eYf97IbmUkojLAxMKXqVvj/Ces2DTwq5IVYjQdBl2oXKb3C2Tt5eg5UHXTgVPt/wjd4/5LvUuWh/FOidxWZfsPlB7Ppgha2ueeWta2Dgvbp2TcvU2fVsheD6w8zCY0d3PCh5RaUcoEsyjg6ioa1Rh591qwSu6gsp71TVqjfuFbo/kYamb2jWCx+OjW9z8LVK0pgrlOmaqW5rY2DCYUR1o74XtYp6u6HXMqD0u7fpG2rAoeVDwRlUtb7qlEkiy8PXrqG9bqlvYluNBwdqN84VKXHYAlc9RKTlbjwXIp/sWYbnOKirVqxzXCB6FMqioV4nfol4l88DL2wJ1VKhTas+rBU859itux0vhJq41cCrr06rrDmy78bZC8D52c7Viw7/sC2zYC5huqyoW6AT1J3l5yqLgGeZkjirPpdBdAeettQiqjxtAWG27w+jMBKxhYj8cdvWa8nbqXlxPtgr1iy5IVj1vuR9Ojk5nm3+q1Z1E8nZ1yJP681f2gCOdaKqqL+u/cYG8FXTWehXO/I7Ukrp3JHXfq79foBx+fN7EMhQvMHkjfnzOyHs4NNX42fky4lTweQzmHj3Cnt70L5wpNd1o97JH2j9xnhSDebjrHDGdbE/vqe6VMO86Py76B3o7h4/FXNOu1+elLp/enfxDTZ5j/PHZXeLa8yK1tr/qBOIHZx6G4nSG6TmhyUGhui4T6t16ZLs+df7lc0IvUIzxNPw8HTbr9Xq1GZ4+I9NQ3tZ/a9CgQYMGDRo0aNCgQYMGDRq8IXp2kKD+FOArKJ+f+EYwdquYeJZntePV4r5IlDKYbPbvG7MbDz3pcjIK0r27NjUt/lM1VZCSBg9gGrNNTbpGZIlF5O/L9XcsUXcH3IIOSxwh6noXRZ1T3yLSXUzGlLsqROWaB5CcAyQPzxrXC07L+j6/K6+zjkfibg/4DjYr4IZhunNQyyT0ytyNGL0td3ZomHRbpvdEssrclf7bcmdVP+RNnXk2oyiaXi6GMiPZ66V/T6PoyBYgz9x7ThSlB+X2epevFP8QDScq8aSm+soCe6qqen56yGlSLUD98v5jUhj57NLX3jhz763p35Y6pHZ+/R/9znnL9+w/z/tyRTX+PmqjefWlYImS1HqUFIEJk6xTpOvWgr4VahqQjFhpHMZdOp7S3Dx1bbTGc5RUgmRghbMsURftbK/+fLOB5fl9nT493iqtoL9fUur99b7baUX0Lskdbr0zd+RaqiWx5Dx10modrTY6p4+fZHByj2hgnkldydzhhrUY20yUlLxSXNq5E61jW+c1Jo+Dfsq9HQ+PZsgO2EQ+HfP08rmCBitjJmxOcaRSqavplGkqRW+PU7/NcPGZO6vMltbZpU5B0ucT30ZhO4DZJjJHb+uJl6vgQuEgocC4j6DUKV8McDP8TkuHr5G1u025Z0fOARsXjM7FCVd6+4u9uSNpW+Jm0TPuKmz3HitxRmAuMNV31G/Bdk+rEZ6PuIb2nb6dxFWgIyn5iSFBWzE3wzIk3DmHZULFTc6P7p7u5iitbZi3e8vxWFJZutcfcqfvLe0PW8RKd1GXr1AySSgEXrEQx5G16VmfjHCO2czuzB1nryk5WVE6sJEBuVNZT4d+h7TViBqKds1+MiHQ09g+T/jJQG+jdjoKIvdL1Qiu4N6bMGufbPOt5B74CPdpN0DbP2PyAJg2E3g6PXNylyxpTFmpXhiGHdqRC+OdwUH0nahDnjs1bufiCayMV7RFYm8JdTAr6QQEiR2rl3BfqOlRU0znWZ0SMN4ZZnT+xooaQ+50mJ8Lck6pjvgjJPg2Mbb9RwPFOC7tTg1WKgSTjDvmJmysXhWd1wHuU5R5cWnlIF242i48TLYjVN5nOaEDxt1OKtyloagLd9ajU22fpGOEke6k7l7CnZlHfNG2MJn5CFOvrwZHJltyfHLsljHdHWI2J5kxb57+y8bCpc+3qFVHc/ZW5onlMujgoJ4L+ycZCuOh1PYyx8BgWxA8YaevFwzYVlZELO/Ls6RkdyhzTFnZCiR1F5uLfU9kEVltz6Matpzs6AwQMyPOOvdyu95+EQxjllQOxCi+fR2Bq8N0efoaInagmJbkSDNLjpINzdG5as2SeXoancVi1tdNL41sywTPgRo4UvoKxcdgpVuaTCgky9oOj6yv232L/q1+Dr8sS0ucnZVHP9C+FrsvlX3Vcxm3Cb1sWZ7uLuDuWeb26hWFQ0RET5lOhhSncKZc5jE95zQcOi17RpEaQfbB57TXCyL6n1MazArY5Wkxu3ZQ8pX/b6DMmbl7j2b/bRxYGENsv+ZZ2FGhU3fff+8fxCfB2Hu77cC/gk7suvO3XZ38GQyGVz9EgwYNGjRo0KBBgwYNGjRo0KDBC/A/QZL/N+Qz0uUAAAAASUVORK5CYII=)
  |![ReadTheDocs](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKSRkPX_ETIigeNFnIlFaJOE1UclOUDbzp2w&usqp=CAU)
  |![Docusaurus](data:image/png;base64,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)
  |![MkDocs](data:image/png;base64,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)
  """.stripMargin)
  .veautifulSlide(<.div(<.h1("Markdown"),
    MDLive()
  ))
  .landscapeImageSlide("https://raw.githubusercontent.com/wbillingsley/ascilite-2020-talk/master/images/overleaf_smaller.png", "Academics have written content in code-like ways since the 1980s")
  .sectionTitle("Interlude", "If you were a robot stuck in a maze, how would you find the shortest path to the middle?")
  .veautifulSlide(<.div(
    <.h1("Flood fill algorithm"),
    JellyFlood(w=10, h=10, goalX=5, goalY=5, mazeString = Some(
            """..........
              |.###..###.
              |.#......#.
              |.#.######.
              |.#.#......
              |.#....#...
              |.######.#.
              |.#......#.
              |.###..###.
              |..........""".stripMargin))
  ))
  .sectionTitle("Interlude", "If you were landing on the moon with no throttle control, how would you land safely?")
  .veautifulSlide(<.div(
    <.h2("Landing on the Moon"),
    markdown.Fixed("Let's suppose our thruster can only be *fully on* or *fully off*. (Bang bang control)"),
    coderunner.JSCodable(lander.canvasLand)(tilesMode=false),
    <.pre("""
    |wait(100)
    |
    |while (true) {
    |    if (getVy() > 3) {
    |        setThrust(10)
    |    } else {
    |        setThrust(0)
    |    }
    |}
    """.stripMargin, ^.attr("style") := "margin-top: 100px;")
  ))
  .sectionTitle("Interlude", "What programming languages do GitHub users use in their projects?")
  .veautifulSlide(<.div(
    <.h1("What languages does a GitHub repository use?"),
    GitHubLanguage()
  ))
  .markdownSlide("""
  |# Site hosting on the Jamstack
  |
  |![Blog hosting diagram](resources/ascilite2021/jamstack-architecture.png)
  |
  |You don't have to maintain any servers
  |
  |But your content is fully portable (it's just HTML, JS, and CSS files)
  |
  |And you can still call services (from the browser)
  """.stripMargin)
  .sectionTitle("A static site generator for education?", "(And yes this talk was written in one)")
  .markdownSlide("""
  |# Education is a little different

  |The "Jamstack" is popular enough that there are major corporate sites built using Jekyll or Gatsby, 
  |but as they scale up, they quickly start to look more like complicated software development.

  |Education...

  |* is organised differently
  |  - e.g. Jumping from the notes to the video for the same content

  |* needs *a lot* of *small* and *different* stuff
  |  - e.g. dozens or hundreds of interactive models, all different...

  |So I wrote one that should feel more like scripting ("not harder than LaTeX")
  """.stripMargin)
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
    <.p(^.attr("style") := "font-size: 36pt;", <.a(^.href := "https://doctacular.com", "https://doctacular.com"))
  )).withClass("center middle")
  .markdownSlide("""
  |# Scripting a slide deck
  |
  |```
  |val simpleDeck = DeckBuilder(1920, 1080)
  |  .markdownSlide("# This is a title slide").withClass("center middle")
  |  .markdownSlide(\"\"\"
  |    |# This is a content slide
  |    |
  |    |It's written in Markdown.
  |    |The pipe characters `|` are just there so we can write this
  |    |nicely indented into the code without Markdown complaining.
  |    |
  |    |(We just need to remember to call "stripMargin" to remove them)
  |  \"\"\".stripMargin)
  |  .markdownSlide(\"\"\"
  |    |# Template slides
  |    |
  |    |The next two slides use templates, so we can have simple calls to show
  |    |fullscreen images and other common things we want to do.
  |  \"\"\".stripMargin)
  |  .landscapeImageSlide(
  |    "https://www.une.edu.au/__data/assets/image/0010/293248/Resizedd-Bool123.jpg",
  |    "Booloominbah"
  |  )
  |  .willCcBy
  |  .renderSlides
  |```
  """.stripMargin.replace("\\", ""))
  .markdownSlide("""
  |# Scripting a table of contents

  |```
  site.toc = site.Toc(
    "Home" -> site.HomeRoute,

    "ASCILITE 2021" -> site.Toc(
      "Talk" -> site.addDeck("ascilite2021", ascilite2021.talk),
      "An example deck" -> site.addDeck("example-deck", ascilite2021.simpleDeck),
    )
  )
  |```
  """.stripMargin)
  .markdownSlide("""
  |# Sites built with Doctacular...

  |* [*The Adventures of Will Scala*](https://theintelligentbook.com/willscala)
  |  - A simple course, mostly slides, markdown, and video

  |* [*Thinking about Programming*](https://theintelligentbook.com/thinkingaboutprogramming)
  |  - Previously written as a more complicated site, re-jigged to use Doctacular for its organisation

  |* [*This talk!*](https://wbillingsley.com/ascilite-2021-talk)
  |  - Of course...
  """)
  .markdownSlide("""
  |# Getting started...

  |1. Clone an starter repository
  |
  |2. Write your content
  |
  |3. Push it to your own GitHub repository
  |
  |GitHub Pages will automatically build the site for you.
  """)
  .markdownSlide("<img src='resources/ascilite2021/site-fixed-msg.png' width='1600' alt='A student fixed my bug' />").withClass("center")
  .willCcBy
  .renderSlides


