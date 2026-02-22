package tests.kasspresso_learning.matchers.shape.shapematchers

import org.hamcrest.Description
import org.hamcrest.TypeSafeDiagnosingMatcher
import tests.kasspresso_learning.matchers.shape.Shape

class LengthRangeMatcher(
  private val minLength: Float,
  private val maxLength: Float
) : TypeSafeDiagnosingMatcher<Shape>
  () {

  override fun matchesSafely(
    item: Shape,
    mismatchDescription: Description
  ): Boolean {
    if (item.length !in minLength..maxLength) {
      mismatchDescription
        .appendText("It was side length range")
        .appendText(" between $minLength and $maxLength")
      return false
    }
    return true
  }

  override fun describeTo(description: Description) {
    description
      .appendText("The length being compared in range ")
      .appendText("between $minLength and $maxLength")
  }
}