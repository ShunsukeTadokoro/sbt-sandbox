package io.ShunsukeTadokoro.SandBox

import algeblic.{Tree, Leaf, Branch}
import Simple.SimpleRNG

import scala.annotation.tailrec

object SandBox {
  def factirial(n: Int): Int = {
    @tailrec
    def _factorial(n: Int, acc: Int = 1): Int = {
      if(n == 0) acc else _factorial(n - 1, acc * n)
    }
    _factorial(n)
  }

  def fib(n: Int): Int = {
    @tailrec
    def _fib(n: Int, acc: Int = 0, prev: Int = 1): Int = {
      if(n == 0) acc else _fib(n - 1, acc + prev, acc)
    }
    _fib(n)
  }

  def findFirst[T](arr: Array[T], p: T => Boolean): Int = {
    @tailrec
    def _findFirst(n: Int = 0): Int = {
      if(n >= arr.length) -1
      else if(p(arr(n))) n
      else _findFirst(n + 1)
    }
    _findFirst()
  }

  def isSorted[A](arr: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def _isSorted(n: Int = 1): Boolean = {
      if(n == arr.length) true
      else if(ordered(arr(n - 1), arr(n))) _isSorted(n + 1)
      else false
    }
    _isSorted()
  }

  def formatResult(name: String, n: Int, f: Int => Int): Unit = {
    val msg = "The %s of %d is %d"
    println(msg.format(name, n, f(n)))

  }

  def curry[A, B, C](f: A => B => C): A => (B => C) = a => f(a)

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)

  def compose[A ,B, C](f: B => C, g: A => B): A => C = a => f(g(a))

  def main(args: Array[String]) {
    formatResult("Factorial", 4, factirial)
    formatResult("Fibonacci", 4, fib)

    val arr = Array(1,2,3)
    println(isSorted(arr, (a: Int, b: Int) => a < b))

    val tree = Branch(Branch(Leaf(3), Branch(Branch(Leaf(5), Leaf(3)), Leaf(19))), Leaf(7))
    println(Tree.size(tree))
    println(Tree.maximum(tree))
    println(Tree.depth(tree))
    println(Tree.map(tree, (x:Int) => x * x))

    val rng = SimpleRNG(42)
    val (n1, rng1) = rng.nextInt
    val (n2, rng2) = rng1.nextInt
    val (n3, rng3) = rng2.nextInt
    println(n1)
    println(n2)
    println(n3)
  }
}
