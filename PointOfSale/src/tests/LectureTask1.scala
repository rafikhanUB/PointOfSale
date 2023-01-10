package tests

import org.scalatest.FunSuite
import store.model.items.{Item}

class LectureTask1 extends FunSuite {

  test("Lecture Task 1") {
    val EPSILON: Double = 0.001
    def compareDoubles(d1: Double, d2: Double): Boolean = {
      Math.abs(d1 - d2) < EPSILON
    }
    val Candy1 = new Item("Reese's",2.00)
    val Candy2 = new Item("Twix",1.50)


    assert(compareDoubles(Candy1.price(),2.00))
    assert(Candy1.description()=="Reese's")

    assert(compareDoubles(Candy2.price(),1.50))
    assert(Candy2.description()=="Twix")

    Candy1.scanned()
    assert(Candy1.timesScanned()==1)
    assert(Candy2.timesScanned()==0)

    Candy1.scanned()
    Candy1.scanned()

    assert(Candy1.timesScanned()==3)




  }

}
