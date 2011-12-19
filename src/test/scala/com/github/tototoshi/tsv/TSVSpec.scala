package com.github.tototoshi.tsv

import org.scalatest.Spec

class TSVSpec extends Spec {

  describe("TSV") {

    it ("should work fine!") {
      val data = "foo" :: "bar" :: "baz" :: Nil
      println(TSV(data))
      assert(TSV(data) === "foo	bar	baz")
    }

    it ("should support backslash escape") {
      val data = "foo" :: "bar" :: "	baz" :: Nil
      println(TSV(data))
      assert(TSV(data) === "foo	bar	\\	baz")

      val data2 = "foo" :: "bar" :: "\\baz" :: Nil
      println(TSV(data2))
      assert(TSV(data2) === "foo	bar	\\\\baz")
    }
  }
}

