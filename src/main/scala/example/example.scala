package example

import org.scalajs.dom
import dom.{Event, html, raw}

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.jquery.jQuery

object Example extends js.JSApp {
  def showInput(container: String) {
    jQuery(s"#$container").append("""<input id="xinput"></input>""")
    jQuery(s"#$container").append("""<p id="xp">sss</p>""")
    jQuery("#xinput").on("keyup", {
      (e: dom.Event) =>
        dom.window.console.info("helloWorld", jQuery("#xinput").value().toString)
        jQuery("#xp").text(dom.window.btoa(jQuery("#xinput").value().toString))
    })

    /*dom.document.onkeyup = {
      (e: dom.Event) =>
        outputEle.textContent = dom.window.btoa(inputEle.value)
    }*/
  }

  def addClickedMessage(): Unit = {
    jQuery("body").append("<p>You clicked the button!</p>")
  }

  def setupUI(): Unit = {
    jQuery("#click-me-button").click(addClickedMessage _)
    jQuery("body").append("<p>Hello World</p>")
  }

  def main(): Unit = {


    val paragraph = dom.document.createElement("p")
    paragraph.innerHTML = "<strong>It works!</strong>"
    dom.document.getElementById("container").appendChild(paragraph)

    val exampleDiv = dom.document.createElement("div")
    exampleDiv.textContent = "Hi from Scala-js-dom"
    dom.document.getElementById("container").appendChild(exampleDiv)

    jQuery("#container").append("""<pre id="xx"></pre>""")

    jQuery("body").append("<p>[message]</p>")

    dom.document.onmousemove = {
      (e: dom.MouseEvent) =>
        jQuery("#xx").text(
          s"""e.clientX ${e.clientX}
              |e.clientY ${e.clientY}
              |e.pageX   ${e.pageX}
              |e.pageY   ${e.pageY}
              |e.screenX ${e.screenX}
              |e.screenY ${e.screenY}
       """.stripMargin)
    }
    showInput("container")

  }
}
