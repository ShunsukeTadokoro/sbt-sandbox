//package io.ShunsukeTadokoro.laziness
//import io.ShunsukeTadokoro.{Option, None, Some}
//
///**
// * @author Shunsuke Tadokoro
// */
//trait Stream[+A] {
//
//  def headOption: Option[A] = this match {
//    case Empty => None
//    case Cons(h, t) => Some(h())
//  }
//
//  def toList: List[A] = {
//    def _toList(s: Stream[A], acc: List[A] = Nil): List[A] = s match {
//      case Empty => acc
//      case Cons(h, t) => _toList(t(), h() :: acc)
//    }
//    _toList(this)
//  }
//
//  def take(n: Int): Stream[A] = {
//    def _take(s: Stream[A], n: Int): Stream[A] = s match {
//      case Empty => s
//      case _ if n == 0 => s
//      case Cons(h, t) => _take(Cons(h,  t), n - 1)
//    }
//    _take(this, n)
//  }
//
//  def drop(n: Int): Stream[A] = {
//    def _drop(s: Stream[A], n: Int): Stream[A] = s match {
//      case Empty => s
//      case _ if n == 0 => s
//      case Cons(h, t: Stream[A]) if n > 0 => _drop(t, n - 1)
//    }
//    _drop(this, n)
//  }
//}
//case object Empty extends Stream[Nothing]
//case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]
//
//object Stream {
//  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
//    lazy val head = hd
//    lazy val tail = tl
//    Cons(() => head, () => tail)
//  }
//  def empty[A]: Stream[A] = Empty
//
//  def apply[A](as: A*): Stream[A] =
//    if(as.isEmpty) empty
//    else cons(as.head, apply(as.tail: _*))
//}