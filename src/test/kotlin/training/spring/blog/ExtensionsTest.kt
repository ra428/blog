package training.spring.blog

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExtensionsTest {

    @Test
    fun `slug transforms text to url path friendly form`() {
        assertThat("LOWERcase-1234".toSlug()).isEqualTo("lowercase-1234")
        assertThat("to kebab case".toSlug()).isEqualTo("to-kebab-case")
    }
}
