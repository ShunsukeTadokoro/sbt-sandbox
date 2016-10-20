package io.ShunsukeTadokoro

sealed trait MyList[+A]
case object MyNil extends MyList[Nothing]
case class Cons[+A](head: A, tail:MyList[A]) extends MyList[A]


object MyList {
  def sum(ints: MyList[Int]): Int = ints match {
    case MyNil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: MyList[Double]): Double = ds match {
    case MyNil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): MyList[A] =
    if (as.isEmpty) MyNil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](l: MyList[A]): MyList[A] = l match {
    case Cons(_, xs) => xs
    case MyNil => throw new NoSuchElementException
  }

  def setHead[A](x: A, l: MyList[A]): MyList[A] = l match {
    case Cons(_, xs) => Cons(x, xs)
    case MyNil => throw new NoSuchElementException
  }

  def drop[A](l: MyList[A], n: Int): MyList[A] =
    if (n <= 0) l
    else l match {
      case MyNil => MyNil
      case Cons(_, xs) => drop(xs, n - 1)
    }

  def dropWhile[A](l: MyList[A], f: A => Boolean): MyList[A] = l match {
    case MyNil => MyNil
    case Cons(x, xs) if f(x) => dropWhile(xs, f)
    case xs => xs
  }

  def init[A](l: MyList[A]): MyList[A] = {
    def _init(ls: MyList[A], acc: MyList[A] = MyNil): MyList[A] = ls match {
      case Cons(h, t) => _init(t, Cons(h, acc))
      case Cons(h, MyNil) => acc
    }
    _init(l)
  }


}