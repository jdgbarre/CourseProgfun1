package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {

    def loop(acc: Int, c: Int, r: Int): Int = {
      if (c <= 0 || c >= r)
        acc
      else
        loop(acc, c - 1, r - 1) + loop(acc, c, r - 1)
    }

    loop(1, c, r)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    def loop(acc: Int, listChar: List[Char]): Boolean = {
      if (listChar isEmpty) acc == 0
      else if (listChar.head equals '(') loop(acc + 1, listChar.tail)
      else if (listChar.head equals ')') acc > 0 && loop(acc - 1, listChar.tail)
      else loop(acc, listChar.tail)
    }

    loop(0, chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = coins match {

    case Nil => 0
    case m1 :: m2 => {
      if (m1 < money) countChange(money - m1, coins) + countChange(money, m2)
      else if (m1 == money) 1 + countChange(money, m2)
      else countChange(money, m2)
    }

  }
}
