package com.github.tototoshi.tsv

import org.scalatest.Spec

class TSVParserSpec extends Spec {

  describe("TSVParser") {

    it ("should works fine!") {
      val line = """abc	def	ghi	jkl"""
      val result = TSVParser.parse(line).get
      assert(result === List("abc", "def", "ghi", "jkl"))
    }

    it ("can handle the escaped tab character") {
      val lines = io.Source.fromFile("src/test/resources/data/test.tsv").getLines.toList
      val first :: second :: rest = lines
      assert(TSVParser.parse(first).get === List("foo", "bar", "baz	piyo"))
      assert(TSVParser.parse(second).get === List("hoge", "hige", "moge"))
    }

  }

}

