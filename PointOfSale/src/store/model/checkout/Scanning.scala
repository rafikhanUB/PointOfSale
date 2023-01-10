package store.model.checkout

import store.model.items._

class Scanning(SCS:SelfCheckout) extends State(SCS){

    var storeInventory: Map[String,Item] = SCS.storeInventory
    var barcode: String = ""
    var lastBarcode: String = ""
    //var shoppingCart: Map[String,Item] = Map()




    def addItem(barcode: String, item: Item): Unit = {
      storeInventory = storeInventory + (barcode -> item)
    }

    def numberPressed(number: Int): Unit = {
      this.barcode += number.toString
      lastBarcode=barcode
    }

    def clearPressed(): Unit = {
      this.barcode = ""

    }

    def enterPressed(): Unit = {
      //this line searches for the item's barcode in the store inventory
      val resultItem = storeInventory.getOrElse(lastBarcode,new Item("error",0.0))
      resultItem.scanned()

      //this line adds the entered item into the shopping cart
      SCS.shoppingCart = SCS.shoppingCart + (barcode->resultItem)

      //this clears or resets the display
      this.barcode = ""
      SCS.state = new EmptyBarcode(SCS)

    }

    def checkoutPressed(): Unit = {
      SCS.state = new Checkout(SCS)
    }

    def cashPressed(): Unit = {
    }

    def creditPressed(): Unit = {
    }

    def loyaltyCardPressed(): Unit = {

    }

    def displayString(): String = {
      this.barcode


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


  //    def receiptLines(): List[ReceiptLine] = {
//      println(shoppingCart)
//      var result: List[ReceiptLine] = List()
//      for ((barcode,item)<-shoppingCart){
//        var a = 0
//        for (a<-1 to item.timesScanned()){
//          result = result :+ new ReceiptLine(item.itemDescription,item.price())
//        }
//      }
//
//      result
//    }

    def prepareStore(): Unit = {
      // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
      // meant to help you run manual tests.
      //
      // This method is called by the GUI during setup. Use this method to prepare your
      // items and call addItem to add their barcodes. Also add any sales/tax/etc to your
      // items.
      //
      // This method will not be called during testing and you should not call it in your tests.
      // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
      // write a similar method in your Test Suite classes.
    }

  }



