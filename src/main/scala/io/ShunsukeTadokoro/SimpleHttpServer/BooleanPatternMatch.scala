package io.ShunsukeTadokoro.SimpleHttpServer

/**
 * @author Shunsuke Tadokoro
 */

import org.openjdk.jmh.annotations.Benchmark

class BooleanPatternMatch {

  @Benchmark
  def withPatternMatch = doPatternMatch(true)

  @Benchmark
  def withIf = doIf(true)

  def doPatternMatch(boolean: Boolean): String =
    boolean match {
      case true => "true"
      case false => "false"
    }

  def doIf(boolean: Boolean): String = if (boolean) "true" else "else"
}
