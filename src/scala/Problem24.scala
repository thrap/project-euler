package scala

object Problem24 extends App {
  def lexiPerm(list:List[Int], n:Int):String = {
    if (list.size == 0)
      return ""
    val f = (1 until list.length).product
    list(n / f) + lexiPerm(list diff List(list(n / f)), n-(n/f)*f)
  }

  println(lexiPerm((0 to 9).toList, 1000000-1))
}
