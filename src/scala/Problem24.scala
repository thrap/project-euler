package scala

object Problem24 extends App {
  def lexiPerm(list:List[Int], n:Long):String = {
    if (list.size == 0)
      return ""
    val f = (1L to list.length-1L).product
    list((n/f).toInt) + lexiPerm(list.patch((n/f).toInt,Nil,1).toList, n-(n/f)*f)
  }

  println(lexiPerm((0 to 9).toList, 1000000-1))
}
