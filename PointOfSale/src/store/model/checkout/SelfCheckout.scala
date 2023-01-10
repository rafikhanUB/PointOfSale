package store.model.checkout

import store.model.items.Item


//this class is essentially the template for the different states the self checkout system will be in
class SelfCheckout {

  //this line below initializes the GUI in its welcome state, where "hello and welcome to my store" is displayed in the textbox
  var state: State = new Welcome(this)



  //kept these variables to prevent errors and red underlines in other classes
  val chicken:Item = new Item("chicken",5.0)
  var storeInventory: Map[String,Item] = Map("123"->chicken)
  var barcode: String = ""
  var lastBarcode: String = ""
  var shoppingCart: Map[String,Item] = Map()

  //this method adds items to store inventory
  def addItem(barcode: String, item: Item): Unit = {
    storeInventory = storeInventory + (barcode -> item)


  }

  //the rest of these methods will return this.state.methodName and this basically means
  //that the behavior will depend on its current state
  def numberPressed(number: Int): Unit = {
    this.state.numberPressed(number)
    lastBarcode = barcode
  }

  def clearPressed(): Unit = {
    this.state.clearPressed()
  }

  def enterPressed(): Unit = {
    this.state.enterPressed()


  }

  def checkoutPressed(): Unit = {
    this.state.checkoutPressed()
  }

  def cashPressed(): Unit = {
    this.state.cashPressed()
  }

  def creditPressed(): Unit = {
    this.state.creditPressed()
  }

  def loyaltyCardPressed(): Unit = {
    this.state.loyaltyCardPressed()
  }

  def displayString(): String = {
    this.state.displayString()

  }
  def receiptLines(): List[ReceiptLine] = {
    this.state.receiptLines()
  }


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
