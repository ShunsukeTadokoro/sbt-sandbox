package io.ShunsukeTadokoro.SimpleHttpServer

import org.openjdk.jmh.annotations.Benchmark

trait AddOperator {
  def add(x: Int, y: Int): Int = x + y
}

object A extends AddOperator

class StructuralSubtyping {

  @Benchmark
  def withNominalSubtyping: Unit = {
    nominalAdd(A, 1, 2)
  }

  @Benchmark
  def withStructuralSubtyping: Unit = {
    structuralAdd(A, 1, 2)
  }

  def nominalAdd(adder: AddOperator, x: Int, y: Int): Int = {
    adder.add(x, y)
  }

  def structuralAdd(any: {def add(a: Int, b: Int): Int}, x: Int, y: Int): Int = {
    any.add(x, y)
  }
}
