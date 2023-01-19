package com.wellrocha.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DomainTest {
    @Test
    fun `Domain Greeting Test`() {
        assertEquals(Domain().greeting, "Hello Domain!")
    }
}