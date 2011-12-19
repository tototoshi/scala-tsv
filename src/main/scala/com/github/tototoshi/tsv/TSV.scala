package com.github.tototoshi.tsv

object TSV {
  def apply(ss: Seq[String]): String = ss map escape mkString "\t"
  def escape(s: String) = s.replace("\\", "\\\\")replace("\t", "\\\t")
}
