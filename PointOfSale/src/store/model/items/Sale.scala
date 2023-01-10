package store.model.items

class Sale (var percentOff:Double) extends Modifier {

  override def updatePrice(price:Double): Double ={
    price*(1-(percentOff*.01))
  }

  override def computeTax(finalPrice: Double): Double = {
    0.0
  }

}
