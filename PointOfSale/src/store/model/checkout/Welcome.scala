package store.model.checkout

import store.model.items.Item


class Welcome(SCS:SelfCheckout) extends State(SCS){

  override def numberPressed(number: Int): Unit = {
    SCS.state = new Scanning(SCS)
    SCS.numberPressed(number)
  }

  override def clearPressed(): Unit = {
    SCS.state = new Scanning(SCS)


  }

  override def enterPressed(): Unit = {
    SCS.state = new Scanning(SCS)
  }

  override def checkoutPressed(): Unit = {}

  override def cashPressed(): Unit = {}

  override def creditPressed(): Unit = {}

  override def loyaltyCardPressed(): Unit = {}

  override def displayString(): String = {
    "Hello and welcome to my store"
  }

  override def receiptLines(): List[ReceiptLine] = List()

}
