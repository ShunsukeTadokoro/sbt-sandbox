package io.todokr.github

/**
  * Created by todokr on 17/08/17.
  */
trait Emphasize[A] {
  def strong(a: A): After
  def bold(a: A): After
}
