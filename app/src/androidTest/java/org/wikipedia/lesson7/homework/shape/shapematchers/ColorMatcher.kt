package tests.kasspresso_learning.matchers.shape.shapematchers

import org.hamcrest.Description
import org.hamcrest.TypeSafeDiagnosingMatcher
import tests.kasspresso_learning.matchers.shape.Color
import tests.kasspresso_learning.matchers.shape.Shape

class ColorMatcher(
  private val expectedColor: Color
) : TypeSafeDiagnosingMatcher<Shape>() {

  override fun matchesSafely(
    item: Shape,
    mismatchDescription: Description
  ): Boolean {
    if (item.color != expectedColor) {
      mismatchDescription
        .appendText("It was color ")
        .appendText(item.color.name)
      return false
    }
    return true
  }

  override fun describeTo(description: Description) {
    description
      .appendText("The color being compared ")
      .appendText(expectedColor.name)
  }
}