package com.tatianomnom.choozorro.service;

import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

@Test
public class ExampleTest {
    public void testSomething() {
        int a = 1;
        assertThat(a).isBetween(0, 4);
    }
}