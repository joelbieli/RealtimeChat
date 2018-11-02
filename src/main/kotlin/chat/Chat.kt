package chat

/**
 * The chat interface which all sub-types must implement
 */
interface Chat {
    val type: ChatType
    val title: String
}