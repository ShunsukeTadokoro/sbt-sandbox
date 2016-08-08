package io.ShunsukeTadokoro

/**
 * @author Shunsuke Tadokoro
 */
sealed trait Either[+E, +A] {

  def map[B](f: A => B): Either[E, B] = this match {
    case Right(x) => Right(f(x))
    case Left(x) => Left(x)
  }

  def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = this match {
    case Right(x) => f(x)
    case Left(x) => Left(x)
  }

  def orElse[EE >: E ,B >: A](b: => Either[EE, B]): Either[EE, B] = this match {
    case Right(x) => Right(x)
    case Left(_) => b
  }

  def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] =
    this flatMap (aa => b map (bb => f(aa, bb)))
}
case class Left[E](value: E) extends Either[E, Nothing]
case class Right[A](value: A) extends Either[Nothing, A]

object Either {
  def mean(xs: IndexedSeq[Double]): Either[String, Double] = {
    if(xs.isEmpty) Left("mean of empty list!")
    else Right(xs.sum / xs.length)
  }

  def safeDiv(x: Int, y: Int): Either[Exception, Int] =
    try Right(x / y) catch { case e: Exception => Left(e) }

  def Try[A](a: => A): Either[Exception, A] = try Right(a) catch { case e: Exception => Left(e) }
  def insuranceRateQuote(age: Int, numberOfSpeedingTicket: Int): Double = ???

  def parseInsuranceRateQuote(age: String, numberOfSpeedingTicket: Int): Either[Exception, Double] = {
    for {
      a <- Try { age.toInt }
      tickets <- Try { numberOfSpeedingTicket.toInt }
    } yield insuranceRateQuote(a, tickets)
  }

  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = traverse(es)(identity)
  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] = as match {
    case Nil => Right(Nil)
    case h :: t => f(h) flatMap(hh => traverse(t)(f) map (tt => hh :: tt))
  }

}
