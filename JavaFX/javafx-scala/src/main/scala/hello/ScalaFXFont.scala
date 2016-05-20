/*
 * Copyright (c) 2011-2015, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package hello

import scala.reflect.macros.blackbox
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.geometry.{Pos, Insets}
import scalafx.scene.Scene
import scalafx.scene.control.TextArea
import scalafx.scene.effect.DropShadow
import scalafx.scene.input.{MouseEvent, KeyEvent}
import scalafx.scene.layout._
import scalafx.scene.paint.Color._
import scalafx.scene.paint._
import scalafx.scene.text.Text
import scalafx.stage.StageStyle

// Huchede Thomas
// JavaFX in Scala

object ScalaFXFont extends JFXApp {
  var done_txt = new Text {
    text = "Done in "
    styleClass add "basic-font"
    fill = new LinearGradient(
      endX = 0,
      stops = Stops(Color.Red, Color.DarkRed))
  }
  var scala_txt = new Text {
    text = "Scala"
    styleClass add "basic-font"
    fill = new LinearGradient(
      endX = 0,
      stops = Stops(Color.Red, Color.DarkRed))
  }
  var fx_txt = new Text {
    text = "FX"
    styleClass add "basic-font"
    fill = new LinearGradient(
      endX = 0,
      stops = Stops(White, DarkGray)
    )
    effect = new DropShadow {
      color = DarkGray
      radius = 15
      spread = 0.25
    }
  }
  var use = new Text {
    styleClass add "basic-very-small-font"
    text = "Click on the \"fx\" to switch font, then type anything you want !"
    fill = new LinearGradient(
      endX = 0,
      stops = Stops(White, DarkGray)
    )
    effect = new DropShadow {
      color = DarkGray
      radius = 15
      spread = 0.25
    }
  }
  var example = new Text {
    styleClass add "basic-small-font"
    text = "The quick brown fox jumps overs the lazy dog"
  }
  var yourText = new TextArea {
    text = ""
  }
  stage = new PrimaryStage {
    initStyle(StageStyle.UNIFIED)

    title = "ScalaFX Font Demo"
    scene = new Scene {
      stylesheets add getClass.getResource("style.css").toExternalForm
      fill = rgb(38, 38, 38)
      root = new VBox {
        styleClass add "vbox"
        hgrow = Priority.Always
        alignment = Pos.Center
        padding = Insets(50, 80, 50, 80)
        children = Seq(
          new HBox {
            alignment = Pos.Center
            children = Seq(
              done_txt,
              scala_txt,
              fx_txt
            )
          },
          use,
          example,
          yourText
        )
      }
    }
  }
  var controller = new Controller(done_txt, scala_txt, fx_txt, use, example, yourText)
  fx_txt.setOnMouseClicked((m:MouseEvent) => controller.changeFx())
}
