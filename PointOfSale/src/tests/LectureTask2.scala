package tests

import org.scalatest.FunSuite
import store.model.items.{Sale,SaleTestingItem}


class LectureTask2 extends FunSuite {

  test("Lecture Task 2") {
    val EPSILON: Double = 0.001
    def compareDoubles(d1: Double, d2: Double): Boolean = {
      Math.abs(d1 - d2) < EPSILON
    }
    var saleObj: Sale = new Sale(10.0)
    assert(compareDoubles(saleObj.updatePrice(20.0),18.0),"test 1 failed")
    assert(compareDoubles(saleObj.percentOff,10.0),"test 2 failed")
    saleObj.percentOff = 20.0
    assert(compareDoubles(saleObj.updatePrice(20.0),16.0),"test 3 failed")
    saleObj.percentOff = 0
    assert(compareDoubles(saleObj.updatePrice(20.0),20.0),"test 4 failed")
    saleObj.percentOff = 100
    assert(compareDoubles(saleObj.updatePrice(20.0),0.0),"test 5 failed")

    val saleItem = new SaleTestingItem("nope",10.0)
    assert(compareDoubles(saleItem.price(),10.0))

    val sailor = new Sale(50.0)
    saleItem.addSale(sailor)
    assert(compareDoubles(saleItem.price(),5.0))
    val secondSailor = new Sale(100)
    saleItem.addSale(secondSailor)
    assert(compareDoubles(saleItem.price(),0.0))

    val thirdSailor = new Sale(10)
    val saleItem2 = new SaleTestingItem("yup",10.0)
    saleItem2.addSale(thirdSailor)
    assert(compareDoubles(saleItem2.price(),9.0))
    thirdSailor.percentOff=20
    assert(compareDoubles(saleItem2.price(),8.0))



  }
}
