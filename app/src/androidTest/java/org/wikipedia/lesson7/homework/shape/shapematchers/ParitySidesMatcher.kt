package tests.kasspresso_learning.matchers.shape.shapematchers

import org.hamcrest.Description
import org.hamcrest.TypeSafeDiagnosingMatcher
import tests.kasspresso_learning.matchers.shape.Shape

class ParitySidesMatcher : TypeSafeDiagnosingMatcher<Shape>() {

  override fun matchesSafely(
    item: Shape,
    mismatchDescription: Description
  ): Boolean {
    if (item.countSide % 2 != 0) {
      mismatchDescription.appendText("Shape is not have party sides")
      return false
    }
    return true
  }

  override fun describeTo(description: Description) {
    description.appendText("Shape with party sides")
  }
}