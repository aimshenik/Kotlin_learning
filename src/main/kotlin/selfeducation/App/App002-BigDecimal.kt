package selfeducation.App

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import java.math.BigDecimal
import java.math.BigInteger
import java.math.MathContext
import java.math.RoundingMode
import java.util.*


fun main() {
   val x1 = BigDecimal(0.1)
   val x2 = BigDecimal(charArrayOf('3','.','1','4'))
   val x3 = BigDecimal(42)
   val x4 = BigDecimal(1231231231231231231L)
   val x5 = BigInteger.probablePrime(100, Random())
   val x6 = BigDecimal(x5)

   println(x1)
   println(x2)
   println(x3)
   println(x4)
   println(x5)
   println(x6)
   println(BigDecimal("0.1"))

   println("valueOf")
   //valueOf использовать безопаснее
   val bdFromLong1 = BigDecimal.valueOf(123412345678901L)
   val bdFromLong2 = BigDecimal.valueOf(123412345678901L, 2)
   val bdFromDouble = BigDecimal.valueOf(0.1)

   assertEquals("123412345678901", bdFromLong1.toString())
   assertEquals("1234123456789.01", bdFromLong2.toString())
   assertEquals("0.1", bdFromDouble.toString())

   println("compareTo")
   println(BigDecimal.valueOf(0.2).compareTo(BigDecimal.valueOf(0.2)))

   println("equals")
   val bd1 = BigDecimal("1.0")
   val bd2 = BigDecimal("1.00")
   assertFalse(bd1 == bd2)

   println("rounding")
   val bd = BigDecimal("2.5")
   val rounded = bd.round(MathContext(1, RoundingMode.HALF_EVEN))
   assertEquals("2", rounded.toString())

   val roundedTotal: BigDecimal = BigDecimal.valueOf(312.3456432)
      .setScale(2, RoundingMode.HALF_EVEN)
   println(roundedTotal)
}
