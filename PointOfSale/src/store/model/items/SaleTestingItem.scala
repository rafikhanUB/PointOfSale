package store.model.items

class SaleTestingItem (var itemDescription: String, var itemPrice: Double){
  var saleList: List[Sale] = List()

  def addSale(saleInput: Sale): Unit = {
    saleList = saleList :+ saleInput
  }
  def price(): Double = {
    var result = this.itemPrice
    for (sale <- saleList){
      result = sale.updatePrice(result)

    }
    result

  }






}
