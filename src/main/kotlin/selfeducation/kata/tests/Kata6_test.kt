package selfeducation.kata.tests

import com.imshenik.selfeducation.kata.solutions.Kata6_.Companion.toCamelCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestExample {
    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFixed() {
        assertEquals("", toCamelCase(""))
        assertEquals("theStealthWarrior", toCamelCase("the_stealth_warrior"))
        assertEquals("TheStealthWarrior", toCamelCase("The-Stealth-Warrior"))
        assertEquals("ABC", toCamelCase("A-B-C"))
    }
}