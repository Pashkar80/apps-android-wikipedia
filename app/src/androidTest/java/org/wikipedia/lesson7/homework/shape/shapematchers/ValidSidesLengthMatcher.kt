package tests.kasspresso_learning.matchers.shape.shapematchers

import org.hamcrest.Description
import org.hamcrest.TypeSafeDiagnosingMatcher
import tests.kasspresso_learning.matchers.shape.Shape

class ValidSidesLengthMatcher()  : TypeSafeDiagnosingMatcher<Shape>() {

  override fun matchesSafely(
    item: Shape,
    mismatchDescription: Description
  ): Boolean {
    if (item.length < 0) {
      mismatchDescription
        .appendText("It was length ")
        .appendValue(item.length)
      return false
    }
    return true
  }

  override fun describeTo(description: Description) {
    description.appendText("Shape have valid sides length")
  }
}