package store.model.items

class SalesTax(percentTax: Double) extends Modifier {

  override def updatePrice(price: Double): Double = {
    price
  }

  override def computeTax(finalPrice: Double): Double = {
    finalPrice*(percentTax*.01)
  }

}
