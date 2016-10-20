package io.ShunsukeTadokoro

import scala.annotation.tailrec

/**
  * Created by ShunsukeTadokoro on 2016/10/20.
  */
sealed trait MyList[+A] {

  def map[B](f: A => B): MyList[B] = {
    def _loop(xs: MyList[A], acc: MyList[B] = Nil): MyList[B] = xs match {
      case Nil => acc
      case Cons(h, t) => _loop(t, Cons(f(h), acc))
    }
    _loop(this)
  }


  def foldLeft[B](z: B)(f: (B, A) => B): B = this match {
    case Nil => z
    case Cons(h, t) => t.foldLeft(f(z, h))(f)
  }

  def foldRight[B](z: B)(f: (A, B) => B): B = this match {
    case Nil => z
    case Cons(h, t) => f(h, t.foldRight(z)(f))
  }

  def reverse: MyList[A] = this.foldLeft(MyList[A]())((acc, h) => Cons(h, acc))

  def foldRight2[B](z: B)(f: (A, B) => B): B =
    this.reverse.foldLeft(z)((acc, h) => f(h, acc))

  def foldRight3[B](z: B)(f: (A, B) => B): B =
    this.foldLeft((b: B) => b)((bf, h) => b => bf(f(h, z)))(z)

  def length: Int = foldLeft(0)((acc, _) => acc + 1)

}

case object Nil extends MyList[Nothing]
case class Cons[+A](head: A, tail: MyList[A]) extends MyList[A]

object MyList {
  def apply[A](xs: A*): MyList[A] = {
     if (xs.isEmpty) Nil
     else Cons(xs.head, apply(xs.tail: _*))
  }
}