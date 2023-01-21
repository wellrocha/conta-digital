package com.wellrocha.infrastructure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InfrastructureTest {
    @Test
    fun `Infrastructure Greeting Test`() {
        Assertions.assertEquals(Infrastructure().greeting, "Hello Infrastructure!")
    }
}