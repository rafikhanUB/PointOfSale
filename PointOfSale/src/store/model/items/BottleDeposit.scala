package store.model.items

class BottleDeposit(totalDeposit: Double) extends Modifier{
  override def updatePrice(price: Double): Double = {
    price
  }

  override def computeTax(finalPrice: Double): Double ={
    totalDeposit
  }

}
