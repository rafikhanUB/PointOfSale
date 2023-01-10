package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{BottleDeposit, Item, Modifier, Sale, SaleTestingItem, SalesTax}

class LectureTask5 extends FunSuite {


  test("Lecture Task 5") {
    val selfCheckout: SelfCheckout = new SelfCheckout()

    val pork: Item = new Item("pork",10.0)
    val chicken: Item = new Item("pork",20.0)
    val eggs: Item = new Item("eggs",5.0 )
    val milk: Item = new Item("milk",3.00)
    val Sale1: Modifier = new Sale(10)
    val Tax1: Modifier = new SalesTax(15)
    pork.addModifier(Sale1)
    eggs.addModifier(Tax1)


    selfCheckout.addItem("100",pork)
    selfCheckout.addItem("200",chicken)
    selfCheckout.addItem("300",eggs)

    selfCheckout.numberPressed(1)
    assert(selfCheckout.displayString()=="1")
    selfCheckout.numberPressed(5)
    assert(selfCheckout.displayString()=="15")
    selfCheckout.enterPressed()
    assert(selfCheckout.displayString()=="")
    selfCheckout.numberPressed(5)
    selfCheckout.numberPressed(0)
    selfCheckout.numberPressed(0)
    assert(selfCheckout.displayString()=="500")
    selfCheckout.clearPressed()
    assert(selfCheckout.displayString()=="")
    selfCheckout.enterPressed()
    assert(selfCheckout.receiptLines().head.description=="error")

    selfCheckout.addItem("001",milk)
    selfCheckout.numberPressed(0)
    selfCheckout.numberPressed(0)
    selfCheckout.numberPressed(1)
    assert(selfCheckout.displayString().contains("1"))
    selfCheckout.enterPressed()
    assert(selfCheckout.receiptLines().last.description=="milk")

  }
}