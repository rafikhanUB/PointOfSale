package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{BottleDeposit, Item, Modifier, Sale, SaleTestingItem, SalesTax}

class LectureTask6 extends FunSuite {
  val EPSILON: Double = 0.001
  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < EPSILON
  }

  test("test set 1"){

    val selfCheckout: SelfCheckout = new SelfCheckout()

    assert(selfCheckout.displayString().contains("welcome"))
    selfCheckout.clearPressed()
    selfCheckout.enterPressed()
    assert(selfCheckout.receiptLines().head.description=="error")
    assert(compareDoubles(selfCheckout.receiptLines().head.amount,0.0))

  }

  test("testing scanning last item if empty"){
    val selfCheckout: SelfCheckout = new SelfCheckout()
    val chicken: Item = new Item("chicken",5.0)
    selfCheckout.addItem("123",chicken)
    selfCheckout.clearPressed()
    selfCheckout.numberPressed(1)
    selfCheckout.numberPressed(2)
    selfCheckout.numberPressed(3)
    selfCheckout.enterPressed()
    selfCheckout.enterPressed()
    selfCheckout.enterPressed()
    selfCheckout.numberPressed(5)
    selfCheckout.clearPressed()
    selfCheckout.enterPressed()
    assert(compareDoubles(chicken.timesScanned(),3))
    assert(selfCheckout.receiptLines().head.description=="chicken")
    assert(compareDoubles(selfCheckout.receiptLines().head.amount,5.0))
    assert(selfCheckout.receiptLines()(1).description=="chicken")
    assert(compareDoubles(selfCheckout.receiptLines()(1).amount,5.0))
    assert(selfCheckout.receiptLines()(2).description=="chicken")
    assert(compareDoubles(selfCheckout.receiptLines()(2).amount,5.0))
    assert(selfCheckout.receiptLines()(3).description=="error")
    assert(compareDoubles(selfCheckout.receiptLines()(3).amount,0.0))

    selfCheckout.checkoutPressed()
    assert(selfCheckout.displayString()=="cash or credit")
    assert(selfCheckout.receiptLines()(4).description=="subtotal")
    assert(compareDoubles(selfCheckout.receiptLines()(4).amount,15.0))
    assert(selfCheckout.receiptLines()(5).description=="tax")
    assert(compareDoubles(selfCheckout.receiptLines()(5).amount,0.0))
    assert(selfCheckout.receiptLines()(6).description=="total")
    assert(compareDoubles(selfCheckout.receiptLines()(6).amount,15.0))

    selfCheckout.cashPressed()
    assert(selfCheckout.displayString().contains("thank you"))
    assert(selfCheckout.receiptLines().isEmpty)
    selfCheckout.clearPressed()
    assert(selfCheckout.displayString()=="")
    selfCheckout.numberPressed(1)
    assert(selfCheckout.displayString()=="1")


  }
  test("testing scanning last item if empty 2"){
    val selfCheckout: SelfCheckout = new SelfCheckout()
    val chicken: Item = new Item("chicken",5.0)
    val sale: Modifier = new SalesTax(10.0)
    chicken.addModifier(sale)
    selfCheckout.addItem("123",chicken)
    selfCheckout.clearPressed()
    selfCheckout.numberPressed(1)
    selfCheckout.numberPressed(2)
    selfCheckout.numberPressed(3)
    selfCheckout.enterPressed()
    selfCheckout.enterPressed()
    selfCheckout.enterPressed()
    selfCheckout.numberPressed(5)
    selfCheckout.clearPressed()
    selfCheckout.enterPressed()
    assert(compareDoubles(chicken.timesScanned(),3))
    assert(selfCheckout.receiptLines().head.description=="chicken")
    assert(compareDoubles(selfCheckout.receiptLines().head.amount,5.0))
    assert(selfCheckout.receiptLines()(1).description=="chicken")
    assert(compareDoubles(selfCheckout.receiptLines()(1).amount,5.0))
    assert(selfCheckout.receiptLines()(2).description=="chicken")
    assert(compareDoubles(selfCheckout.receiptLines()(2).amount,5.0))
    assert(selfCheckout.receiptLines()(3).description=="error")
    assert(compareDoubles(selfCheckout.receiptLines()(3).amount,0.0))

    selfCheckout.checkoutPressed()
    assert(selfCheckout.displayString()=="cash or credit")
    assert(selfCheckout.receiptLines()(4).description=="subtotal")
    assert(compareDoubles(selfCheckout.receiptLines()(4).amount,15.0))
    assert(selfCheckout.receiptLines()(5).description=="tax")
    assert(compareDoubles(selfCheckout.receiptLines()(5).amount,1.5))
    assert(selfCheckout.receiptLines()(6).description=="total")
    assert(compareDoubles(selfCheckout.receiptLines()(6).amount,16.5))

    selfCheckout.creditPressed()
    assert(selfCheckout.displayString().contains("thank you"))
    assert(selfCheckout.receiptLines().isEmpty)
    selfCheckout.clearPressed()
    assert(selfCheckout.displayString()=="")
    selfCheckout.numberPressed(1)
    assert(selfCheckout.displayString()=="1")


  }






}