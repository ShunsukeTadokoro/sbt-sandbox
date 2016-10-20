//package io.ShunsukeTadokoro.SimpleHttpServer
//
//import java.io.{BufferedInputStream, FileInputStream, File}
//
//import org.mozilla.universalchardet.UniversalDetector
//import org.openjdk.jmh.annotations._
//import java.net._
//
///**
// * @author Shunsuke Tadokoro
// */
//@State(Scope.Thread)
//class ChardetParformance {
//
//  val limit = 131072
//
//  def readFile: Array[Byte] = {
//    val fileIn = new BufferedInputStream(new FileInputStream(new File("/Users/shunsuke.tadokoro/Desktop/文字化け事例/all/kaigo-kyuujin.htm")))
//    val siteBytes = Iterator.continually(fileIn.read).takeWhile(_ != -1).map(_.toByte).toArray
//    assert(siteBytes.length >= limit)
//    siteBytes
//  }
//
//  val data = readFile
//
//  @Benchmark
//  def detect1k: Unit = {
//    val ud = new UniversalDetector(null)
//    ud.handleData(data, 0, 1024)
//    ud.dataEnd()
//    val detectedCharsetName = Option(ud.getDetectedCharset).getOrElse("Unknown")
//    println(s"charset: $detectedCharsetName")
//  }
//
//  @Benchmark
//  def detect2k: Unit = {
//    val ud = new UniversalDetector(null)
//    ud.handleData(data, 0, 2048)
//    ud.dataEnd()
//    val detectedCharsetName = Option(ud.getDetectedCharset).getOrElse("Unknown")
//    println(s"charset: $detectedCharsetName")
//  }
//
//  @Benchmark
//  def detect4k: Unit = {
//    val ud = new UniversalDetector(null)
//    ud.handleData(data, 0, 4096)
//    ud.dataEnd()
//    val detectedCharsetName = Option(ud.getDetectedCharset).getOrElse("Unknown")
//    println(s"charset: $detectedCharsetName")
//  }
//
//  @Benchmark
//  def detect8k: Unit = {
//    val ud = new UniversalDetector(null)
//    ud.handleData(data, 0, 8192)
//    ud.dataEnd()
//    val detectedCharsetName = Option(ud.getDetectedCharset).getOrElse("Unknown")
//    println(s"charset: $detectedCharsetName")
//  }
//
//  @Benchmark
//  def detect16k: Unit = {
//    val ud = new UniversalDetector(null)
//    ud.handleData(data, 0, 16384)
//    ud.dataEnd()
//    val detectedCharsetName = Option(ud.getDetectedCharset).getOrElse("Unknown")
//    println(s"charset: $detectedCharsetName")
//  }
//
//  @Benchmark
//  def detect32k: Unit = {
//    val ud = new UniversalDetector(null)
//    ud.handleData(data, 0, 32768)
//    ud.dataEnd()
//    val detectedCharsetName = Option(ud.getDetectedCharset).getOrElse("Unknown")
//    println(s"charset: $detectedCharsetName")
//  }
//
//  @Benchmark
//  def detect64k: Unit = {
//    val ud = new UniversalDetector(null)
//    ud.handleData(data, 0, 65536)
//    ud.dataEnd()
//    val detectedCharsetName = Option(ud.getDetectedCharset).getOrElse("Unknown")
//    println(s"charset: $detectedCharsetName")
//  }
//
//  @Benchmark
//  def detect128k: Unit = {
//    val ud = new UniversalDetector(null)
//    ud.handleData(data, 0, 131072)
//    ud.dataEnd()
//    val detectedCharsetName = Option(ud.getDetectedCharset).getOrElse("Unknown")
//    println(s"charset: $detectedCharsetName")
//  }
//}
