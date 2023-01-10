package store.model.items

abstract class Modifier() {

  def updatePrice(price:Double): Double ={
    price
  }
  def computeTax(finalPrice:Double): Double = {
    finalPrice
  }


}
