package store.model.checkout

abstract class State(SCS:SelfCheckout) {

  def numberPressed(number: Int)
  def clearPressed()
  def enterPressed()
  def checkoutPressed()
  def cashPressed()
  def creditPressed()
  def loyaltyCardPressed()
  def displayString(): String
  def receiptLines(): List[ReceiptLine]

}
