//package io.ShunsukeTadokoro
//
//import scala.annotation.tailrec
//
///**
// * @author Shunsuke Tadokoro
// */
//object FPScala {
//
//  def main(args: Array[String]): Unit = {
//
//    def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
//      @tailrec
//      def loop(n: Int): Boolean =
//        if (n >= as.length) true
//        else if (ordered(as(n-1), as(n))) loop(n+1)
//        else false
//
//      loop(1)
//    }
//
//
//    println(isSorted(Array(1, 2, 3), (e1: Int, e2: Int) => e1 < e2))
//
//
//    def partial1[A, B, C](a: A, f: (A, B) => C): B => C = (b) => f(a, b)
//
//    def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)
//
//    def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)
//
//    def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))
//
//    val list1 = List(Right(1), Right(3), Right(3), Right(3), Right(3))
//    val list2 = List(Right(1), Right(3), Left("hoge"), Right(3), Left("fuga"))
//    println(Either.traverse(list1)(_.map(_ * 2)))
//    println(Either.traverse(list2)(_.map(_ * 2)))
//
//    case class Person(name: Name, age: Age)
//    sealed class Name(val value: String)
//    sealed class Age(val value: Int)
//
//    def mkName(name: String): Either[String, Name] =
//      if(name == "" || name == null) Left("invalid name")
//      else Right(new Name(name))
//
//    def mkAge(age: Int): Either[String, Age] =
//      if(age < 0) Left("invalid age")
//      else Right(new Age(age))
//
//    def mkPerson(name: String, age: Int): Either[String, Person] =
//      mkName(name).map2(mkAge(age))(Person)
//  }
//}
