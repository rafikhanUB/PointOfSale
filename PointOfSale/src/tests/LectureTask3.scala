package tests

import org.scalatest.FunSuite
import store.model.items.{BottleDeposit,Item,Modifier,Sale,SalesTax,SaleTestingItem}

class LectureTask3 extends FunSuite {

  test("Lecture Task 2") {
    val EPSILON: Double = 0.001

    def compareDoubles(d1: Double, d2: Double): Boolean = {
      Math.abs(d1 - d2) < EPSILON
    }

    val salesTax: Modifier = new SalesTax(20.0)
    val sale: Modifier = new Sale(10.0)
    val BD: Modifier = new BottleDeposit(0.05)

    assert(compareDoubles(salesTax.computeTax(12.0),2.4))
    assert(compareDoubles(salesTax.updatePrice(12.0),12.0))
    assert(compareDoubles(sale.computeTax(12.0),0.0))
    assert(compareDoubles(BD.computeTax(12.0),0.05))
    assert(compareDoubles(BD.updatePrice(12.0),12.0))

    val salesTax1: Modifier = new SalesTax(0.0)
    val sale1: Modifier = new Sale(0.0)
    val BD1: Modifier = new BottleDeposit(0.0)

    assert(compareDoubles(salesTax1.computeTax(12.0),0.0))
    assert(compareDoubles(salesTax1.updatePrice(12.0),12.0))
    assert(compareDoubles(sale1.computeTax(12.0),0.0))
    assert(compareDoubles(BD1.computeTax(12.0),0.0))
    assert(compareDoubles(BD1.updatePrice(12.0),12.0))



  }
}