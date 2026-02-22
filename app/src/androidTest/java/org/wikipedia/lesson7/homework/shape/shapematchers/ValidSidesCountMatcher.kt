package tests.kasspresso_learning.matchers.shape.shapematchers

import org.hamcrest.Description
import org.hamcrest.TypeSafeDiagnosingMatcher
import tests.kasspresso_learning.matchers.shape.Shape

class ValidSidesCountMatcher() : TypeSafeDiagnosingMatcher<Shape>() {

  override fun matchesSafely(
    item: Shape,
    mismatchDescription: Description
  ): Boolean {
    if (item.countSide < 0) {
      mismatchDescription
        .appendText("It was count side ")
        .appendValue(item.countSide)
      return false
    }
    return true
  }

  override fun describeTo(description: Description) {
    description
      .appendText("Shave have valid sides count")
  }
}