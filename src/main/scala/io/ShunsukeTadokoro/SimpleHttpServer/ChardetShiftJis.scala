package io.ShunsukeTadokoro.SimpleHttpServer

import java.io.{BufferedInputStream, FileInputStream, File}
import java.nio.charset.Charset
import org.jsoup.Jsoup
import org.mozilla.universalchardet.UniversalDetector
import scala.math._
/**
 * @author Shunsuke Tadokoro
 */
object ChardetShiftJis {

  def main(args: Array[String]) {
    println("Start character detect...")
    //val file = new File("/Users/shunsuke.tadokoro/Desktop/文字化け事例/求人かごしま/kyujin-kagoshima.htm")
    //val file = new File("/Users/shunsuke.tadokoro/Desktop/文字化け事例/介護求人ナビ/kaigo-kyuujin.htm")
    val file = new File("/Users/shunsuke.tadokoro/Desktop/文字化け事例/ナースエージェント/nurse-agent.htm")
    //val file = new File("/Users/shunsuke.tadokoro/Desktop/文字化け事例/キララサポート介護/kirara-support.html")
    //val file = new File("/Users/shunsuke.tadokoro/Desktop/文字化け事例/ナースエージェント/nurse-agent.htm")


    val fileIn = new BufferedInputStream(new FileInputStream(file))

    val siteBytes = Iterator.continually(fileIn.read).takeWhile(_ != -1).map(_.toByte).toArray
    val ud = new UniversalDetector(null)
    ud.handleData(siteBytes, 0, min(1024, siteBytes.length))
    ud.dataEnd()
    val detectedCharsetName = Option(ud.getDetectedCharset).getOrElse("Unknown")
    println(s"charset: $detectedCharsetName")
    val charset = Charset.forName(detectedCharsetName)
    println(charset.displayName)
    println(Jsoup.parse(file, detectedCharsetName).title)
  }
}
