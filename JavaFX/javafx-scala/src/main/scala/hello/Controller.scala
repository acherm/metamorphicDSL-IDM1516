package hello

import scalafx.scene.control.TextArea
import scalafx.scene.text.{Text, Font}

class Controller (var done : Text , var scala : Text , var fx : Text , var use : Text , var ex : Text , var yours : TextArea ){

  private val fonts = "../fonts/bb.otf"::"../fonts/fo.otf"::"../fonts/comic.ttf"::"../fonts/hobbit.ttf"::"../fonts/nasa.ttf"::"../fonts/sc.ttf"::"../fonts/star.ttf"::Nil
  private var current_fonts = fonts

  def changeFx() : Unit = {
    val str = current_fonts.head
    val bf = Font.loadFont(getClass.getResource(str).toExternalForm, 50)
    val sf = Font.loadFont(getClass.getResource(str).toExternalForm, 30)
    done.setFont(bf)
    scala.setFont(bf)
    fx.setFont(bf)
    ex.setFont(sf)
    yours.setFont(sf)
    yours.requestFocus()

    if (current_fonts.tail == Nil){
      current_fonts = fonts
    } else {
      current_fonts = current_fonts.tail
    }
  }
}
