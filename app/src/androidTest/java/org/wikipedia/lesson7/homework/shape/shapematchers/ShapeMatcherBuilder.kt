package tests.kasspresso_learning.matchers.shape.shapematchers

import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import tests.kasspresso_learning.matchers.shape.Color
import tests.kasspresso_learning.matchers.shape.Shape

class ShapeMatcherBuilder {

  val shapeMatchers: MutableList<Matcher<Shape>> = mutableListOf()

  fun withColor(color: Color) {
    shapeMatchers.add(ColorMatcher(color))
  }

  fun withValidSidesCount() {
    shapeMatchers.add(ValidSidesCountMatcher())
  }

  fun withLengthRange(minLength: Float, maxLength: Float) {
    shapeMatchers.add(LengthRangeMatcher(minLength, maxLength))
  }

  fun withValidSidesLength() {
    shapeMatchers.add(ValidSidesLengthMatcher())
  }

  fun withParitySides() {
    shapeMatchers.add(ParitySidesMatcher())
  }

  fun withCountCorner(expectedCornerCount: Int) {
    shapeMatchers.add(CornerMatcher(expectedCornerCount))
  }

  fun build(): Matcher<Shape> {
    return allOf(shapeMatchers)
  }
}

fun filter(shape: List<Shape>, fnc: ShapeMatcherBuilder.() -> Unit): List<Shape> {
  val builder = ShapeMatcherBuilder()
  builder.fnc()
  val matchers = builder.build()
  return shape.filter { matchers.matches(it) }
}