package com.github.tototoshi.tsv

import scala.util.parsing.combinator._

import scalaz._
import Scalaz._

object TSVParser extends RegexParsers {

  override def skipWhitespace = false

  private def char = """[^\t]""".r
  private def escapedTab = "\\\t" ^^ { _ => "\t"}
  private def backslash = "\\\\" ^^ { _ => "\\"}

  private def cell = rep(escapedTab | backslash | char) ^^ { _.mkString }
  private def tab  = "\t"

  private def line = repsep(cell, tab)

  def parse(in: String) = parseAll(line, in)

}
