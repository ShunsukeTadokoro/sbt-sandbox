package io.ShunsukeTadokoro

/**
 * @author Shunsuke Tadokoro
 */
sealed trait Option[+A] {

  def map[B](f: A => B): Option[B] = {
    this match {
      case Some(x) => Some(f(x))
      case None => None
    }
  }

  def getOrElse[B >: A](default: => B): B = {
    this match {
      case Some(x) => x
      case None => default
    }
  }

  def flatMap[B](f: A => Option[B]): Option[B] = {
    this match {
      case Some(x) => f(x)
      case None => None
    }
  }

  def flatMap2[B](f: A => Option[B]): Option[B] = map(f) getOrElse None

  def orElse[B >: A](ob: => Option[B]): Option[B] = {
    this match {
      case Some(x) => Some(x)
      case None => ob
    }
  }

  def orElse2[B >: A](ob: => Option[B]): Option[B] = this map(Some(_)) getOrElse ob

  def filter(f: A => Boolean): Option[A] = {
    this match {
      case Some(x) if f(x) => this
      case _ => None
    }
  }

  def mean(xs: Seq[Double]): Option[Double] = {
    if(xs.isEmpty) None
    else Some(xs.sum / xs.size)
  }

  def variance(xs: Seq[Double]): Option[Double] = {
    mean(xs) flatMap { m =>
      if(xs.isEmpty) None
      else mean(xs.map(x => math.pow(x - m, 2)))
    }
  }

  // println(absO(Some(-2.4)))
}
case class Some[A](value: A) extends Option[A]
case object None extends Option[Nothing]



object Option {
  def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f
  val absO: Option[Double] => Option[Double] = lift(math.abs)

  def Try[A](a: => A): Option[A] = try Some(a) catch { case e: Exception => None}


  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    a flatMap { x =>
      b map { y =>
        f(x, y)
      }
    }
  }

  def insuranceRateQuote(age: Int, numberOfSpeedingTicket: Int): Double = ???

  def parseInsuranceRateQuote(age: String, numberOfSpeedingTicket: Int): Option[Double] = {
    val optAge : Option[Int] = Try(age.toInt)
    val optTicket: Option[Int] = Try(numberOfSpeedingTicket.toInt)
    map2(optAge, optTicket)(insuranceRateQuote)
  }

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    a match {
      case Nil => Some(Nil)
      case h :: t => f(h).flatMap(hh => traverse(t)(f).map(tt => hh :: tt))
    }
  }

  def sequence[T](a: List[Option[T]]): Option[List[T]] = traverse(a)(identity)

  def parseInts(a: List[String]): Option[List[Int]] = sequence(a map (i => Try(i.toInt)))
}

