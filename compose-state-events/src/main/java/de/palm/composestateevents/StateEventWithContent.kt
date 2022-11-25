package de.palm.composestateevents

/**
 *  This [StateEventWithContent] can have exactly 2 states like the [StateEvent] but the triggered state holds a value of type [T].
 */
sealed interface StateEventWithContent<T>

/**
 * The event in its triggered state holding a value of [T]. See [triggered] to create an instance of this.
 * @param content A value that is needed on the event consumer side.
 */
class StateEventWithContentTriggered<T>(val content: T) : StateEventWithContent<T> {
    override fun toString(): String = "triggered($content)"
}

/**
 * The event in its consumed state not holding any value. See [consumed] to create an instance of this.
 */
class StateEventWithContentConsumed<T> : StateEventWithContent<T> {
    override fun toString(): String = "consumed"
}

/**
 * A shorter and more readable way to create an [StateEventWithContent] in its triggered state holding a value of [T].
 * @param content A value that is needed on the event consumer side.
 */
fun <T> triggered(content: T) = StateEventWithContentTriggered(content)

/**
 * A shorter and more readable way to create an [StateEventWithContent] in its consumed state.
 */
fun <T> consumed() = StateEventWithContentConsumed<T>()
