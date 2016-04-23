package io.ShunsukeTadokoro

import org.hjson._
import play.api.libs.json.Json

object HjsonSample {

  def main(args: Array[String]) {

    val hjson =
      """
        |{
        |  # コメントが付けられる
        |
        |  // これもコメント
        |
        |  /*
        |   * 複数行の
        |   * コメントも
        |   * 大丈夫
        |   */
        |
        |  // keyやvalueをクオートで囲む必要がない
        |  // 末尾のカンマも不要
        |  name: Shunsuke Tadokoro
        |
        |  // 配列もカンマ不要
        |  color: [
        |    red
        |    green
        |    blue
        |  ]
        |
        |  // valueにカンマが入っていてもOK
        |  hello: Hello, HJSON!
        |
        |  // クオートなしの場合、エスケープは不要
        |  regex: ^\d{2,4}\.\w+?-\d+
        |  html: <h1>HTML Element</h1>
        |
        |  // シングルクオート3つで囲むと改行を含められる
        |  poem:
        |    '''
        |    若さ 若さってなんだ ふりむかないことさ
        |    愛ってなんだ ためらわないことさ
        |    '''
        |}
      """.stripMargin

    // JSONオブジェクトとしてパース
    val jsonObj = JsonValue.readHjson(hjson).asObject

    println("Name: "   + jsonObj.get("name").asString)
    println("Colors: " + jsonObj.get("color").asArray)
    println("Greet: "  + jsonObj.get("hello").asString)
    println("Regex: "  + jsonObj.get("regex").asString)
    println("HTML: "   + jsonObj.get("html").asString)

    // 普通のJSON文字列にパースすることもできるので、そのあとはお好みのJSONパーサーで扱える
    val nomalJsonStr = JsonValue.readHjson(hjson).toString
    val nomalJson = Json.parse(nomalJsonStr)

    println("Name: " + (nomalJson \ "poem").as[String])

  }

}
