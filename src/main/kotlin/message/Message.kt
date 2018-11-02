package message

import java.time.Instant

/**
 * The Message interface all sub-types have to implement
 */
interface Message {
    val text: String
    val timestamp: Instant
    val edited: Boolean
}