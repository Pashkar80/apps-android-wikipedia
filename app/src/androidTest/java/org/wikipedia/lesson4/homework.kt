import kotlin.random.Random

class Inventory(val items : MutableList<String>) {

    operator fun plus(item: String): List<String> {
        this.items.add(item)
        return this.items
    }

    operator fun get(index: Int): String {
        return this.items.get(index)
    }

    operator fun contains(item: String): Boolean {
        return (item in this.items)
    }
}

class Toggle(val enabled: Boolean) {

    operator fun not() : Toggle  = Toggle(!enabled)
}

class Price(val amount: Int) {

    operator fun times(count: Int): Int {
        return this.amount * count
    }
}

class Step(val number: Int) {

    operator fun rangeTo(that: Step): IntRange {
        return this.number..that.number
    }
}

operator fun IntRange.contains(that: Step): Boolean {
    return that.number in this
}

class Log() {

    val entries: MutableList<String> = mutableListOf()

    operator fun plus(entry: String): Log {
        this.entries.add(entry)
        return this
    }
}


class Person(private val name: String) {

    private val phrases = mutableListOf<String>()

    fun print() {
        println(phrases.joinToString(" "))
    }

    private fun selectPhrase(first: String, second: String): String {
        val random = Random.nextInt(0, 2)
        return if (random == 0) first else second
    }

    infix fun says(text: String): Person {
        this.phrases.add(text)
        return this
    }

    infix fun and(text: String): Person {
        check (phrases.size == 0) { "First says" }
        this.phrases.add(text)
        return this
    }

    infix fun or(text: String): Person {
        check (phrases.size == 0) { "First says" }
        phrases[phrases.lastIndex] = selectPhrase(text, phrases[phrases.lastIndex])
        return this
    }
}



