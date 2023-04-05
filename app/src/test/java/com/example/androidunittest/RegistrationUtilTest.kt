package com.example.androidunittest

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {


    //TDD -> test driven development
    /**
     * the input is not valid if..
     * ..the username/password is empty
     * ..the username already taken
     * ..the confirmed password is not same as the real password
     * ..the password contains less than 2 digits number
     */

    private val regisUtil = RegistrationUtil()

    @Test
    fun `empty username return false` () {
        val result = regisUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true` () {
        val result = regisUtil.validateRegistrationInput(
            "Philipp",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false` () {
        val result = regisUtil.validateRegistrationInput(
            "Carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirmed password return false` () {
        val result = regisUtil.validateRegistrationInput(
            "Philipp",
            "123456",
            "abcdefg"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password return false` () {
        val result = regisUtil.validateRegistrationInput(
            "Philipp",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than2digit password return false` () {
        val result = regisUtil.validateRegistrationInput(
            "Philipp",
            "abcdefg5",
            "abcdefg5"
        )
        assertThat(result).isFalse()
    }
}