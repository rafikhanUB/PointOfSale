package store.model.items

class Item(var itemDescription: String, var itemPrice: Double){
  var modifierList: List[Modifier] = List()
  var numOfScans: Int = 0

  def price(): Double ={
    var finalResult = itemPrice
    for (modifier <- modifierList){
      finalResult = modifier.updatePrice(finalResult)
    }

    finalResult
  }


  def description(): String = {
    this.itemDescription
  }

  def scanned(): Unit = {
    this.numOfScans += 1

  }

  def timesScanned(): Int = {
    this.numOfScans
  }

  def addModifier(modifierInput: Modifier): Unit ={
    modifierList = modifierList :+ modifierInput

  }

  def tax(): Double ={
    var totalTax: Double = 0.0
    for (modifier <- modifierList){
      totalTax += modifier.computeTax(this.price())
    }

    totalTax
  }








  // TODO

}
