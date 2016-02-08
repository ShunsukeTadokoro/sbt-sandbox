package io.ShunsukeTadokoro.SimpleHttpServer

import java.net.ServerSocket

import scala.util.{Failure, Success, Try}
import scalaz._
import Scalaz._

/**
 * @author Shunsuke Tadokoro
 */
object SimpleHttpServer {
  def main(args: Array[String]) {
    val port = if(args.length < 1) 8080 else {
      Try{args(0).toInt} match {
        case Success(v) => v
        case Failure(e) => throw new Exception("Port must be number.")
      }
    }

    println(s"Server starts. Listening at $port...")
    val hoge = Try {new ServerSocket(port)} match {
      case Success(v) => v.right
      case Failure(e) => e.left
    }
    println("Thank you! Come again! - Dr. Apu Nahasapeemapetilon")
  }
}
