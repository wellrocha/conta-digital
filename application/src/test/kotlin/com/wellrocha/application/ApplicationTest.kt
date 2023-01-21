package com.wellrocha.application

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationTest {
    @Test
    fun `Application Greeting Test`() {
        Assertions.assertEquals(Application().greeting, "Hello Application!")
    }
}