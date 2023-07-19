package com.imshenik.selfeducation.kata.tests

import org.junit.Assert.*
import com.imshenik.selfeducation.kata.solutions.Kata6_.Companion.toCamelCase
import org.junit.Test

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