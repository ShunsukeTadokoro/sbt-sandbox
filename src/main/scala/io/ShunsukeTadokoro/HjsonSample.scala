//  package io.ShunsukeTadokoro
//
//  import org.hjson._
//  import play.api.libs.json.Json
//
//  object HjsonSample {
//
//    def main(args: Array[String]) {
//
//      val hjson =
//        """
//          |{
//          |  "name": "SH",
//          |  "color": ["hoge"],
//          |  "hello": "konnitiha",
//          |  "regex": "",
//          |  "html": "<h1>",
//          |  "poem": "hoge"
//          |}
//        """.stripMargin
//
//      // JSONオブジェクトとしてパース
//      val jsonObj = JsonValue.readHjson(hjson).asObject
//
//      println("Name: "   + jsonObj.get("name").asString)
//      println("Colors: " + jsonObj.get("color").asArray)
//      println("Greet: "  + jsonObj.get("hello").asString)
//      println("Regex: "  + jsonObj.get("regex").asString)
//      println("HTML: "   + jsonObj.get("html").asString)
//
//      // 普通のJSON文字列にパースすることもできるので、そのあとはお好みのJSONパーサーで扱える
//      val normalJsonStr = JsonValue.readHjson(hjson).toString
//      val normalJson = Json.parse(normalJsonStr)
//
//      println((normalJson \ "poem").as[String])
//
//    }
//
//  }
