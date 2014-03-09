package scala

object Problem4 extends App{
  var max = 0
  def isPalindrome(x:String):Boolean = x.reverse.equals(x)
  for(a <- 900 to 999; b <- a to 999) {
    if (isPalindrome(""+a*b))
      max = Math.max(a*b, max)
  }
  println(max)
}
