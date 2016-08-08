package io.ShunsukeTadokoro

/**
 * @author Shunsuke Tadokoro
 */

object Iso {

  case class User(id: Id[User], name: String)

  val takashi = User(Id(300), "takashi")
  val hanako = User(Id(20), "hanako")

  val d: Map[User, Id[User]] = List(takashi, hanako).map(u => u -> u.id).toMap
  val e: Map[User, Long] = d.mapValues(Id.idIso.from(_))
}

case class Id[A](value: Long) extends AnyVal
object Id {
  implicit def idIso[A]: Iso[Long, Id[A]] = new Iso[Long, Id[A]] {
    def to(a: Long): Id[A] = Id(a)
    def from(b: Id[A]): Long = b.value
  }
}

trait Prism[A, B] {
  implicit def toOpt(a: A): Option[B]
  implicit def from(b: B): A
}

trait Iso[A, B] extends Prism[A, B] {
  implicit def to(a: A):B
  implicit override def toOpt(a: A): Option[B] = Some(to(a))
}
