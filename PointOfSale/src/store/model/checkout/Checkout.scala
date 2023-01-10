package store.model.checkout

import store.model.items._


class Checkout(SCS:SelfCheckout) extends State(SCS){

  override def numberPressed(number: Int): Unit = {}

  override def clearPressed(): Unit = {}

  override def enterPressed(): Unit = {}

  override def checkoutPressed(): Unit = {}

  override def cashPressed(): Unit = {
    SCS.state = new ThankYou(SCS)
  }

  override def creditPressed(): Unit = {
    SCS.state = new ThankYou(SCS)
  }

  override def loyaltyCardPressed(): Unit = {}

  override def displayString(): String = {

    "cash or credit"

  }
  def receiptLines(): List[ReceiptLine] = {
    var result: List[ReceiptLine] = List()
    var subtotal = 0.0
    var tax = 0.0
    var total = 0.0
    for ((barcode,item)<-SCS.shoppingCart){
      var a = 0
      for (a<-1 to item.timesScanned()){
        result = result :+ new ReceiptLine(item.itemDescription,item.price())

        subtotal += item.price()
        tax += item.tax()
      }
    }
    total = subtotal + tax

    result = result :+ new ReceiptLine("subtotal",subtotal)
    result = result :+ new ReceiptLine("tax",tax)
    result = result :+ new ReceiptLine("total",total)



    result
  }

}
