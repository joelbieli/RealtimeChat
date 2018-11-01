package message

import java.time.Instant

interface Message {
    val text: String
    val timestamp: Instant
    val edited: Boolean
}