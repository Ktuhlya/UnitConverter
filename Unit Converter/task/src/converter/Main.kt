package converter

import java.util.*
import kotlin.system.exitProcess

fun main() {
    choNado()
    }

fun choNado() {
    print("Enter what you want to convert (or exit):")
    val list = readln().lowercase(Locale.getDefault()).split(" ").toList()
    Converter().chekList(list)
}

class Converter() {

      val weightList = listOf<String>( "g", "gram", "grams",
          "kg", "kilogram", "kilograms", "mg", "milligram", "milligrams",
          "lb", "pound", "pounds", "oz", "ounce", "ounces")
      val weightEquals = listOf<Double>(1.0, 1000.0, 0.001, 453.592, 28.3495)
      val lengthList = listOf<String>("m", "meter",  "meters",
          "km", "kilometer", "kilometers", "cm", "centimeter", "centimeters",
          "mm", "millimeter", "millimeters", "mi", "mile", "miles",
          "yd", "yard", "yards", "ft", "foot", "feet", "in", "inch", "inches" )
      val lengthEquals = listOf<Double>(1.0, 1000.0, 0.01, 0.001, 1609.35,
          0.9144, 0.3048, 0.0254)

      fun indL(list: List<Any>, str: String): Int{
          return list.indexOf(str)/3
      }
      fun printResult(inp: Double, inpInd: Int, outInd: Int,
                      list: List<String>, equal: List<Double> ){
          var strIn: String = ""
          strIn = if (inp == 1.0) list[inpInd+1] else list[inpInd+2]
          var convers = (inp * equal[inpInd]) / equal[outInd]
          var strOut = ""
          strOut = if (convers==1.0) list[outInd+1] else list[outInd+2]
          println(("$inp $strIn is $convers $strOut"))
          println()
          choNado()
      }

      fun chekList (list: List<String>) {

            when {
                list[0] == "exit" -> exitProcess(0)
                ((weightList.contains(list[1])) && (weightList.contains(list[3]))) -> {
                    val inpInd = indL(weightList, list[1])
                    val outInd = indL(weightList, list[3])
                    printResult(list[0].toDouble(), inpInd, outInd, weightList, weightEquals)
                }
                ((lengthList.contains(list[1])) && (lengthList.contains(list[3]))) -> {
                    val inpInd = indL(lengthList, list[1])
                    val outInd = indL(lengthList, list[3])
                    printResult(list[0].toDouble(), inpInd, outInd, lengthList, lengthEquals)
                }
                ((!weightList.contains(list[1])) && (weightList.contains(list[3]))
                        && (lengthList.contains(list[1]))) -> {
                  println("Conversion from ${lengthList[indL(lengthList,list[1])+2]} " +
                          "to ${weightList[indL(weightList,list[1])+2]} is impossible")
                    choNado()
                }
                ((!lengthList.contains(list[1])) && (lengthList.contains(list[3]))
                        && (weightList.contains(list[1]))) -> {
                  println("Conversion from ${weightList[indL(weightList,list[1])+2]} " +
                          "to ${lengthList[indL(lengthList,list[3]) +2]} is impossible")
                    choNado()
                }
                ((!lengthList.contains(list[1])) && (!weightList.contains(list[1]))
                        && (lengthList.contains(list[3]))) -> {
                  println("Conversion from ??? " +
                          "to ${lengthList[indL(lengthList,list[3]) +2]} is impossible")
                    choNado()
                }
                ((!lengthList.contains(list[1])) && (!weightList.contains(list[1]))
                        && (weightList.contains(list[3]))) -> {
                  println("Conversion from ??? " +
                          "to ${weightList[indL(weightList,list[3]) +2]} is impossible")
                    choNado()
                }





            }



      }


 }

/*
 in meter -> println(meters(list[0].toDouble()))
             in km -> println(kilometers(list[0].toDouble()))
             in cm -> println(centimeters(list[0].toDouble()))
             in mm -> println(millimeters(list[0].toDouble()))
             in mil -> println(miles(list[0].toDouble()))
             in yrd -> println(yards(list[0].toDouble()))
             in ft -> println(feet(list[0].toDouble()))
             in inch -> println(inches(list[0].toDouble()))
             else -> println("Wrong input. Unknown unit ${list[1]}")
              private fun meters (int: Double): String {
          var str = ""
          str = if (int.toInt() ==1) "meter" else "meters"
          return ("$int $str is ${int*1} $str")
     }
      private fun kilometers (int: Double): String {
          var str = ""
          val result = int*1000
          var meters = "meters"
          if (result == 1.0)  meters = "meter"
          str = if (int.toInt() ==1) "kilometer" else "kilometers"
          return ("$int $str is ${int*1000} $meters")
     }
      private fun centimeters (int: Double): String {
          var str = ""
          val result =int*0.01
          var meters = "meters"
          if (result == 1.0)  meters = "meter"
          str = if (int.toInt() ==1) "centimeter" else "centimeters"
          return ("$int $str is ${int*0.01} $meters")
     }

      private fun millimeters (int: Double): String {
          var str = ""
          val result = int*0.001
          var meters = "meters"
          if (result == 1.0)  meters = "meter"
          str = if (int.toInt() ==1) "millimeter" else "millimeters"
          return ("$int $str is ${int*0.001} $meters")
     }
      private fun miles (int: Double): String {
          var str = ""
          val result = int * 1609.35
          var meters = "meters"
          if (result == 1.0)  meters = "meter"
          str = if (int.toInt() ==1) "mile" else "miles"
          return ("$int $str is ${int*1609.35} $meters")
     }
      private fun yards (int: Double): String {
          var str = ""
          val result = int*0.9144
          var meters = "meters"
          if (result == 1.0)  meters = "meter"
          str = if (int.toInt() ==1) "yard" else "yards"
          return ("$int $str is ${int*0.9144} $meters")
     }
      private fun feet (int: Double): String {
          var str = ""
          val result = int * 0.3048
          var meters = "meters"
          if (result == 1.0)  meters = "meter"
          str = if (int.toInt() ==1) "foot" else "feet"
          return ("$int $str is ${int*0.3048} $meters")
     }
      private fun inches (int: Double): String {
          var str = ""
          val result = int * 0.0254
          var meters = "meters"
          if (result == 1.0)  meters = "meter"
          str = if (int.toInt() ==1) "inch" else "inches"
          return ("$int $str is ${int*0.0254} $meters")
     }

 */



