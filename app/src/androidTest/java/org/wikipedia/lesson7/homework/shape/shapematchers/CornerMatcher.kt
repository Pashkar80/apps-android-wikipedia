package tests.kasspresso_learning.matchers.shape.shapematchers

import org.hamcrest.Description
import org.hamcrest.TypeSafeDiagnosingMatcher
import tests.kasspresso_learning.matchers.shape.Shape

class CornerMatcher(private val expectedCornerCount: Int) : TypeSafeDiagnosingMatcher<Shape>() {
  override fun matchesSafely(
    item: Shape,
    mismatchDescription: Description
  ): Boolean {
    if (item.countSide < 3) {
      mismatchDescription.appendText("Shape have ${item.countSide} line is not have corners")
      return false
    }

    return if (item.countSide == expectedCornerCount) {

      true
    } else {
      mismatchDescription.appendText("$expectedCornerCount is not equals ")
        .appendValue(item.countSide)
      false
    }
  }

  override fun describeTo(description: Description) {
    description.appendText("Shape with $expectedCornerCount")
  }
}