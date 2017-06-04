package io.todokr.github

import freestyle._
import freestyle.implicits._

@free trait Validation {
  def minsize(s: String, n: Int): FS[Boolean]
  def hasNumber(s: String): FS[Boolean]
}

@free trait Interaction {
  def tell(msg: String): FS[Unit]
  def ask(prompt: String): FS[String]
}
