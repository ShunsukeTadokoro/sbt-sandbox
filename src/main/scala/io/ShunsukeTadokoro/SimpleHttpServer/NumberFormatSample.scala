package io.ShunsukeTadokoro.SimpleHttpServer

import java.text.{DecimalFormat, NumberFormat}
import java.util.{Formatter, Currency, Locale}


/**
 * @author Shunsuke Tadokoro
 */
object NumberFormatSample {
  def main(args: Array[String]) {

    val n:Double = 12345678.0

    def usFormat = {
      val nf = NumberFormat.getCurrencyInstance(Locale.US)
      nf.format(n)
    }

    def inFormat = {
      def convert(salary: Double): String = {
        val s = "%.2f".format(salary).split('.')
        val integral = s.head
        val fraction = s.last

        def comma(raw: List[Char], acc: List[Char] = Nil): String = raw match {
          case Nil => s"Rs ${acc.mkString}"
          case n1 :: n2 :: n3 :: Nil if acc == Nil  => comma(Nil, n3 :: n2 :: n1 :: acc)         // 末尾3桁の区切り(きりよく終わる場合)
          case n1 :: n2 :: n3 :: tail if acc == Nil => comma(tail, ',' :: n3 :: n2 :: n1 :: Nil) // 末尾3桁の区切り
          case n1 :: n2 :: Nil                      => comma(Nil, n2 :: n1 :: acc)               // 2桁区切り(きりよく終わる場合)
          case n1 :: n2 :: tail                     => comma(tail, ',' :: n2 :: n1 :: acc)       // 2桁区切り
          case x :: tail                            => comma(tail, x :: acc)
        }

        val integralResult = comma(integral.reverse.toList)
        integralResult + (if(fraction != "00") s".$fraction")
      }

      convert(1234567)
    }

    def jpFormat = {
      val nf = NumberFormat.getCurrencyInstance(Locale.JAPAN)
      nf.format(n).drop(1)
    }

    //println(s"US: $usFormat")
    println(s"IN: $inFormat")
    //println(s"JP: $jpFormat")

  }
}
