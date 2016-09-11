package example

/**
  * Created by shaoshengrong on 16/9/11.
  */
import  utest._
import org.scalajs.jquery.jQuery

object ExampleTest extends TestSuite{
  Example.setupUI()
  def tests = TestSuite{
    'HelloWorld {
      assert(jQuery("p:contains('Hello World')").length == 1)
    }
  }
}
