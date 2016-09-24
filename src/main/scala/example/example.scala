package example

import org.scalajs.dom
import dom.{Event, html, raw}

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.jquery.jQuery
import dom.ext.Ajax
import com.thoughtworks.binding.Binding.Var

import com.thoughtworks.binding.{dom => bindingDom}

import scala.concurrent.ExecutionContext.Implicits.global

import scala.util.Random
import scalacss.DevDefaults._
import scalacss._

object Demo extends StyleSheet.Inline {

  import dsl._

  val hello = style(
    height(100 px),
    width(30 px))

  val hello2 = keyframe(
    height(150 px),
    width(30 px))

  val kf1 = keyframes(
    (0 %%) -> hello,
    (20 %%) -> hello2,
    (100 %%) -> keyframe(
      height(200 px),
      width(60 px))
  )

  val anim1 = style(
    animationName(kf1))
}

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

  def ajaxDemo(): Unit = {
    Ajax.get("http://114.55.224.242:7022/").foreach {
      xhr =>
        println(xhr.responseText)
    }
  }

  def main(): Unit = {

    // ajaxDemo()
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
    jQuery("body").append("""<div id="dxd">""")
    jQuery("body").append("""<div id="dx1"></div>""")
    jQuery("body").append("""<div id="dx2"></div>""")
    jQuery("body").append("""<div><p>helloWorld</p></div>""")
    jQuery("div > p").css("color", "black")
    jQuery("<div><p>HelloWorld,Sorry</p></div>").appendTo("body")
    val i = Var("sxs")
    //jQuery("body").css( "background", "red" );
    jQuery("input", Map(
      "type" -> "text",
      "val" -> "test",
      "focusin" -> {
        event: Event =>
          dom.window.alert("Helloxx")
      },
      "focusout" -> {
        event: Event =>
          dom.window.alert("xxxx")
      }
    )).appendTo("body")



    // bindingDom.render(dom.document.body, InputBinding.input(i))
    bindingDom.render(dom.document.getElementById("dxd"), InputBinding.spinner(i))
    bindingDom.render(dom.document.getElementById("dx1"), InputBinding.renderDom)
    bindingDom.render(dom.document.getElementById("dx2"), Button.button(i))


    jQuery("#dyn").fadeIn({
      evt: Event =>
        jQuery("#dyn").addClass("negative")
        dom.console.log("add negative")
    })
    jQuery("#dyn").fadeOut({
      evt: Event =>
        jQuery("#dyn").removeClass("negative")
        dom.console.log("remove negative")
    })


    jQuery("<select><option value=\"1\">Flowers</option>\n  <option value=\"2\" selected=\"selected\">Gardens</option>\n  <option value=\"3\">Trees</option></select>").appendTo("body")
    dom.console.log(jQuery(":button").length)
    dom.console.log(jQuery("div").length, jQuery("div").index())
    dom.console.log("data : ", jQuery("#dyn").data("test"))
    jQuery("#dyn").data("test", Map("first" -> 1, "second" -> 2).mkString(""))
    dom.console.log(jQuery("#dyn").data("test"))
    /*dom.window.setInterval(() => {
      i := Random.nextString(10)
    }, 1000)*/

    dom.console.log(MyStyles.render)
  }
}
