package io.ShunsukeTadokoro

//sealed trait MyList[+A]
//case object Nil extends MyList[Nothing]
//case class Cons[+A](head: A, tail:MyList[A]) extends MyList[A]

//object MyList {
//  def sum(ints: MyList[Int]): Int = ints match {
//    case Nil => 0
//    case Cons(x, xs) => x + sum(xs)
//  }
//
//  def product(ds: MyList[Double]): Double = ds match {
//    case Nil => 1.0
//    case Cons(0.0, _) => 0.0
//    case Cons(x, xs) => x * product(xs)
//  }
//
//  def apply[A](as: A*): MyList[A] =
//    if (as.isEmpty) Nil
//    else Cons(as.head, apply(as.tail: _*))
//
//  def tail[A](l: MyList[A]): MyList[A] = l match {
//    case Cons(_, xs) => xs
//    case Nil => throw new NoSuchElementException
//  }
//
//  def setHead[A](x: A, l: MyList[A]): MyList[A] = l match {
//    case Cons(_, xs) => Cons(x, xs)
//    case Nil => throw new NoSuchElementException
//  }
//
//  def drop[A](l: MyList[A], n: Int): MyList[A] =
//    if (n <= 0) l
//    else l match {
//      case Nil => Nil
//      case Cons(_, xs) => drop(xs, n - 1)
//    }
//
//  def dropWhile[A](l: MyList[A], f: A => Boolean): MyList[A] = l match {
//    case Nil => Nil
//    case Cons(x, xs) if f(x) => dropWhile(xs, f)
//    case xs => xs
//  }
//}