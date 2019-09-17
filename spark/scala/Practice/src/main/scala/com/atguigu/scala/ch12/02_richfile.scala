package com.atguigu.scala.ch12.sec02

import java.io.File
import scala.io.Source
import scala.language.implicitConversions

object Main extends App {
  class RichFile(val from: File) {
    def read = Source.fromFile(from.getPath).mkString
  }

  implicit def file2RichFile(from: File) = new RichFile(from)
val  file = new File("RichFile.scala").getAbsolutePath
  println(file)
  val source2 = Source.fromFile("D:\\dgg\\learning\\spark\\scala\\Practice\\src\\main\\scala\\com\\atguigu\\scala\\ch13\\sec01\\mary.txt", "UTF-8")
  val iter = source2.buffered
  val contents = new File("RichFile.scala").read

  println(contents)
}

/*
object Main extends App {
  implicit class RichFile(val from: File) extends AnyVal {
    def read = Source.fromFile(from.getPath).mkString
  }

  val contents = new File("RichFile2.scala").read
  println(contents)
}*/
