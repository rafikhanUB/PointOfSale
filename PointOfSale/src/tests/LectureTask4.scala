package tests

import org.scalatest.FunSuite
import store.model.items.{BottleDeposit,Item,Modifier,Sale,SalesTax,SaleTestingItem}

class LectureTask4 extends FunSuite {

  test("Lecture Task 2") {
    val EPSILON: Double = 0.001

    def compareDoubles(d1: Double, d2: Double): Boolean = {
      Math.abs(d1 - d2) < EPSILON
    }
    val item1: Item = new Item("Tokyo Chicken",10.0)
    val salesTax: Modifier = new SalesTax(20.0)
    val sale: Modifier = new Sale(10.0)
    val BD: Modifier = new BottleDeposit(0.05)
    val salesTax2: Modifier = new SalesTax(50.0)

    val sale3: Sale = new Sale(10)

    item1.addModifier(sale)
    assert(compareDoubles(item1.price(),9.0))
    item1.addModifier(salesTax)
    assert(compareDoubles(item1.tax(),1.8))
    item1.addModifier(BD)
    assert(compareDoubles(item1.tax(),1.85))
    item1.addModifier(salesTax2)
    assert(compareDoubles(item1.tax(),6.35))

    item1.addModifier(sale3)
    assert(!compareDoubles(item1.price(),9.0))
    assert(compareDoubles(item1.price(),8.1))
    sale3.percentOff = 20
    assert(!compareDoubles(item1.price(),8.1))
    assert(compareDoubles(item1.price(),7.2))

    val item2: Item = new Item("Sofa",100.0)
    val sale2: Modifier = new Sale(20)
    val salesTax3: Modifier = new SalesTax(6)
    val salesTax4: Modifier = new SalesTax(4)
    item2.addModifier(sale2)
    assert(compareDoubles(item2.price(),80))
    item2.addModifier(salesTax3)
    item2.addModifier(salesTax4)
    assert(compareDoubles(item2.tax(),8))


  }
}