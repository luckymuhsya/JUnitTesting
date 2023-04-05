package com.example.androidunittest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ResourceComparerTest {

    private val resourceComparer= ResourceComparer()

    /**
     * Testing untuk memastikan string sama dengan test
     */
    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "AndroidUnitTest")
        assertThat(result).isTrue()
    }
    /**
     * Testing untuk memastikan string berbeda dengan test
     */
    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Hallo")
        assertThat(result).isFalse()
    }
}