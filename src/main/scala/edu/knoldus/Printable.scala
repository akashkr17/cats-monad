package edu.knoldus

import cats.Show
import cats.Show
import cats.instances.int._ // for Show
import cats.instances.string._ // for Show
import cats.syntax.show._
trait Printable[A] {
  def format(value: A): String
}


object PrintableInstances {
  implicit val stringPrintable: Printable[String] = (input: String) => input
  implicit val intPrintable: Printable[Int] = (input: Int) => input.toString
//  implicit val catPrintable: Printable[Cat] = new Printable[Cat] {
//    def format(cat: Cat): String = {
//      val name = Printable.format(cat.name)
//      val age = Printable.format(cat.age)
//      val color = Printable.format(cat.color)
//      s"$name is a $age year-old $color cat."
//    }
//  }

  implicit val catShow = Show.show[Cat] { cat =>
      val name = cat.name.show
    val age = cat.age.show
    val color = cat.color.show
      s"$name is a $age year-old $color cat."

  }
}

object Printable {
  def format[A](input: A)(implicit p: Printable[A]): String =
    p.format(input)
  def print[A](input: A)(implicit p: Printable[A]): Unit =
    println(format(input))
}


final case class Cat(name: String, age: Int, color: String)