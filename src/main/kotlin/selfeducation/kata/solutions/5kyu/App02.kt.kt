package selfeducation.kata.solutions.`5kyu`

import com.imshenik.selfeducation.App.fact
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object App02 {

    val basys = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    fun dec2FactString(n: Long): String {
        var result = ""
        var dividend = n
        for (i in 1..basys.length) {
            result = basys[(dividend % i).toInt()] + result
            dividend /= i
            if (dividend.toInt() == 0) break
        }
        return result
    }

    fun factString2Dec(str: String) = str.reversed().mapIndexed { idx, symbol ->
        basys.indexOf(symbol) * (if (idx == 0) 0 else fact(idx))
    }.sum()
}

class Dec2FactTest {

    private fun testing1(nb: Long, expect: String) {
        val actual: String = App02.dec2FactString(nb)
        assertEquals(expect, actual)
    }

    private fun testing2(str: String, expect: Long) {
        val actual: Long = App02.factString2Dec(str)
        assertEquals(expect, actual)
    }

    @Test
    fun basicTests1() {
        testing1(36288000L, "A0000000000")
        testing1(2982L, "4041000")
        testing1(463L, "341010")

    }

    @Test
    fun basicTests2() {
        testing2("341010", 463L)
        testing2("4042100", 2990L)
        testing2("27A0533231100", 1273928000L)

    }
}