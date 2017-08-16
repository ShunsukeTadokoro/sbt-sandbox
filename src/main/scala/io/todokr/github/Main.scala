package io.todokr.github

/**
  * Created by todokr on 17/08/17.
  */
object Main {

  def convert[T: Emphasize](x: T): String = implicitly[Emphasize[T]].strong(x).name

  def main(args: Array[String]): Unit = {
    val as = Seq(BeforeA("john"), BeforeA("paul"), BeforeA("george"), BeforeA("ringo"))
    val bs = Seq(BeforeB("inaba"), BeforeB("matsumoto"))

    implicit val emphasizeA = new Emphasize[BeforeA] {
      override def strong(x: BeforeA): After = After(s"<strong>${x.name}</strong>")
      override def bold(x: BeforeA): After = After(s"<b>${x.name}</b>")
    }

    implicit val emphasizeB = new Emphasize[BeforeB] {
      override def strong(x: BeforeB): After = After(s"${x.name}!!!!!!!!!!!!!!!!!!!!")
      override def bold(x: BeforeB): After = After(s"☆☆${x.name}☆☆")
    }

    println(as.map(convert(_)))
    println(bs.map(convert(_)))
  }

}
