package example

/**
  * Created by shaoshengrong on 16/9/20.
  */
/**
  * elements button
  */

import com.thoughtworks.binding._
import com.thoughtworks.binding.Binding.Var
import org.scalajs.dom.Event
import org.scalajs.dom.window

object Button {

  sealed trait Emphasis

  case object NoEmphasis extends Emphasis

  case object Primary extends Emphasis

  case object Secondary extends Emphasis

  @dom
  def button(msg: Var[String]) = {
    <button id="dyn" class="ui primary button" onclick={event: Event =>
      window.alert("HelloWorld")}>Save</button>
      <button class="ui button">
        {msg.bind.toString}
      </button>
  }
}
