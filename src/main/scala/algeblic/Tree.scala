package algeblic

/**
  * Created by ShunsukeTadokoro on 2016/08/07.
  */
sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def size[A](tree: Tree[A]): Int = {
    tree match {
      case Leaf(_) => 1
      case Branch(l, r) => size(l) + size(r) + 1
    }
  }

  def maximum(tree: Tree[Int]): Int = {
    def _loop(t: Tree[Int], acc: Int = 0): Int = {
      t match {
        case Leaf(x) => x max acc
        case Branch(x, y) => _loop(x, acc) max _loop(y, acc)
      }
    }
    _loop(tree)
  }

  def depth[A](tree: Tree[A]): Int = {
    def _loop(tree: Tree[A], acc: Int = 0): Int = {
      tree match {
        case Leaf(_) => acc
        case Branch(x, y) => _loop(x, acc + 1) max _loop(y, acc + 1)
      }
    }
    _loop(tree)
  }

  def map[A](tree: Tree[A], f: A => A): Tree[A] = {
    tree match {
      case Branch(x, y) => Branch(map(x, f), map(y, f))
      case Leaf(x) => Leaf(f(x))
    }
  }

}