package io.ShunsukeTadokoro

import org.scalatest.FunSuite

class HListTest extends FunSuite {

  test("dropWhile") {

    val list = MyList(2,4,6,8,10,11,12)
    val f = (n:Int) => n % 2 == 0
    val result = MyList.dropWhile(list, f)
    println(result)

    assert(result == MyList(11, 12))
  }
}
