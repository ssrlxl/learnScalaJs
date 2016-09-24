package example

import com.thoughtworks.binding.Binding.{Var, Vars}
import com.thoughtworks.binding.dom
import org.scalajs.dom.document
import org.scalajs.dom.raw.Event


/**
  * Created by shaoshengrong on 16/9/11.
  */

/**
  * https://github.com/ThoughtWorksInc/Binding.scala
  */

object LearnBinding {

  case class Contact(name: Var[String], email: Var[String])

  val data = Vars.empty[Contact]

  @dom
  def getTable = {
    <div>
      <button
      onclick={event: Event =>
        data.get += Contact(Var("Yang Bo"), Var("yang.bo@rea-group.com"))}>
        Add a contact
      </button>
    </div>
      <table border="1" cellPadding="5" class="ui celled table">
        <thead>
          <tr>
            <th>Name</th>
            <th>E-mail</th>
            <th>Operation</th>
          </tr>
        </thead>
        <tbody>
          {for (contact <- data) yield {
          <tr>
            <td>
              {contact.name.each}
            </td>
            <td>
              {contact.email.each}
            </td>
            <td>
              <button class="ui button"
              onclick={event: Event =>
                contact.name := "Modified Name"}>
                Modify the name
              </button>
            </td>
          </tr>
        }}
        </tbody>
      </table>
  }

}
