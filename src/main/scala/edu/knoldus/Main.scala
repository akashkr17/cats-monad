package edu.knoldus

import cats.instances.int._
import cats.instances.string._
import PrintableInstances._
import Printable._
import cats.Show
import cats.syntax.show._ // for show
object Main extends App {

  val cat = Cat("Garfield", 41, "ginger and black")
//  Printable.print(cat)

  val showInt: Show[Int] = Show.apply[Int]
  val showString: Show[String] = Show.apply[String]


  //convert to string cats effect
  showInt.show(123)
  showString.show("abc")

  123.show
  "abc".show

  println(Cat("Garfield", 38, "ginger and black").show)
}