package com.atguigu.scala.ch10.sec09

trait Logger {
  def log(msg: String)
}

trait ConsoleLogger extends Logger {
  def log(msg: String) { println(msg) }
}

trait ShortLogger extends Logger {
  val maxLength: Int // An abstract field
  abstract override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg
      else s"${msg.substring(0, maxLength - 3)}...")
  }
}

class Account {
  protected var balance = 0.0
}

abstract class SavingsAccount extends Account with Logger {
  var interest = 0.0
  def withdraw(amount: Double) {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }

  // More methods ...
}

object Main extends App {
  val acct = new SavingsAccount with ConsoleLogger with ShortLogger {
    val maxLength = 20
  }
  acct.withdraw(100)
  if(acct.isInstanceOf[Account]) println("acct.isInstanceOf[Account]")
  if(acct.isInstanceOf[Logger]) println("acct.isInstanceOf[Logger]")
  if(acct.isInstanceOf[ConsoleLogger]) println("acct.isInstanceOf[ConsoleLogger]")
  if(acct.isInstanceOf[ShortLogger]) println("acct.isInstanceOf[ShortLogger]")

  if(acct.getClass == classOf[Logger]) println("cct.getClass == classOf[Logger]")
  println(acct.getClass)
  println(classOf[Logger])
    // Log message is not truncated because maxLength is 20
}

