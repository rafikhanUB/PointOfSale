package store.model.checkout

class EmptyBarcode(SCS:SelfCheckout) extends State(SCS){

  override def numberPressed(number: Int): Unit = {
    SCS.state = new Scanning(SCS)
    SCS.numberPressed(number)
  }

  override def clearPressed(): Unit = {}

  override def enterPressed(): Unit = {
    val lastItem =(SCS.shoppingCart.values.last)
    lastItem.scanned()


  }

  override def checkoutPressed(): Unit = {
    SCS.state = new Checkout(SCS)
  }

  override def cashPressed(): Unit = {
  }

  override def creditPressed(): Unit = {
  }

  override def loyaltyCardPressed(): Unit = {
  }

  override def displayString(): String = {
  ""
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


      }
    }


    result
  }
}
