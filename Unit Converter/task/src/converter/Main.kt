package converter

import java.util.*

fun main() {
    print("Enter a number and a measure of length: ")
    val list = readln().lowercase(Locale.getDefault()).split(" ").toList()
    Converter().chekList(list)


    }
  class Converter() {
      val meter = listOf<String>("m", "meter",  "meters")
      val km = listOf<String>("km", "kilometer", "kilometers")
      val cm = listOf<String>( "cm", "centimeter", "centimeters")
      val mm = listOf<String>("mm", "millimeter", "millimeters")
      val mil = listOf<String>( "mi", "mile", "miles")
      val yrd = listOf<String>("yd", "yard", "yards")
      val ft = listOf<String>("ft", "foot", "feet")
      val inch = listOf<String>("in", "inch", "inches")

      fun chekList (list: List<String>) {
         when(list[1]){
            in meter -> println(meters(list[0].toDouble()))
             in km -> println(kilometers(list[0].toDouble()))
             in cm -> println(centimeters(list[0].toDouble()))
             in mm -> println(millimeters(list[0].toDouble()))
             in mil -> println(miles(list[0].toDouble()))
             in yrd -> println(yards(list[0].toDouble()))
             in ft -> println(feet(list[0].toDouble()))
             in inch -> println(inches(list[0].toDouble()))
             else -> println("Wrong input. Unknown unit ${list[1]}")
         }

      }
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

 }





