package scala

object Problem4 extends App{
  def isPalindrome(x:String):Boolean = x.reverse.equals(x)
  print((for(a <- 900 to 999; b <- a to 999; if isPalindrome(""+(a*b))) yield a*b).max)
}
