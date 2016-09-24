package example

/**
  * Created by shaoshengrong on 16/9/19.
  */

import com.thoughtworks.binding.Binding.{Var, Vars}
import com.thoughtworks.binding.dom
import org.scalajs.dom.document
import org.scalajs.dom.raw.Event

import scala.scalajs.js
import org.scalajs.jquery.jQuery
import org.scalajs.{dom => selfDom}

object InputBinding {

  @dom
  def input(str: Var[String]) = {
    <div class="ui input">
      <input type="text" id="xxx" placeholder="search" onblur={event: Event => str := jQuery("#xxx").value().toString}>

      </input>
    </div>
      <div>
        <p></p>
      </div>
      <p>
        {selfDom.window.btoa(str.bind.toString)}
      </p>
  }

  @dom
  def spinner(loadText: Var[String]) = {
    selfDom.window.setInterval(() => {
      loadText := "sssss"
    }, 5000)


    <div class="ui segment" style="height:100px">
      <div class="ui active dimmer">
        <div class="ui indeterminate text loader">
          {loadText.bind.toString}
        </div>
      </div>
      <p></p>
    </div>
  }

  @dom
  def spinnerD(i: Var[Int]) = {
    <div>
      <button onclick={event: Event => i := i.get - 1}>-</button>{i.bind.toString}<button onclick={event: Event => i := i.get + 1}>+</button>
    </div>
  }

  @dom
  def renderDom = {
    val i = Var(0)
    <div>
      {spinnerD(i).bind}
      空间当前值:
      {i.bind.toString}
    </div>
  }
}
