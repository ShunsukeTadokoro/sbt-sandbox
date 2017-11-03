package io.todokr.github

import scala.util.parsing.combinator._
/**
  * Created by todokr on 17/08/17.
  */
object Main extends App {

  val input =
    """
      |types {
      |   # hoge
      |  application/atom+xml                  atom;
      |  application/json                      json map topojson;
      |  application/ld+json                   jsonld;
      |  application/rss+xml                   rss;
      |  application/vnd.geo+json              geojson;
      |  application/xml                       rdf xml;
      |}
    """.stripMargin

  object MimeConfParser extends RegexParsers {

    override val whiteSpace = """(\s|#.*)+""".r

    // values
    def key = """[\w\./+-]+""".r
    def value = repsep("""[\w\./+-]+""".r, """\s?""".r)
    def line = key ~ value <~ ";"
    def list = """types\s*\{""".r ~> rep(line) <~ "}"

    def parse(in: String): Map[String, Seq[String]] = parseAll(list, in) match {
      case Success(result, _) => result.map(x => x._1 -> x._2).toMap
      case NoSuccess(msg, next) => throw new Exception(s"$msg on line ${next.pos.line} on column ${next.pos.column}")
    }
  }

  MimeConfParser.parse(input)


  println(MimeConfParser.parse(input))
}
