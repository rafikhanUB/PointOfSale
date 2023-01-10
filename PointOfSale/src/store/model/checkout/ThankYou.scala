package store.model.checkout

class ThankYou(SCS:SelfCheckout) extends State(SCS){
  override def numberPressed(number: Int): Unit = {
    SCS.shoppingCart = Map()
    SCS.state = new Scanning(SCS)
    SCS.numberPressed(number)
  }

  override def clearPressed(): Unit = {
    SCS.state = new Scanning(SCS)
  }

  override def enterPressed(): Unit = {
    SCS.state = new Scanning(SCS)
  }

  override def checkoutPressed(): Unit = {
    SCS.state = new Scanning(SCS)
  }

  override def cashPressed(): Unit = {

  }

  override def creditPressed(): Unit = {

  }

  override def loyaltyCardPressed(): Unit = {

  }

  override def displayString(): String = {
    "thank you"
  }

  override def receiptLines(): List[ReceiptLine] = List()
}
