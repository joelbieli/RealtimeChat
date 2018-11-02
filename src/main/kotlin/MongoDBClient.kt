import chat.MDBChat
import message.MDBMessage
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import user.MDBUser

/**
 * This class sets up the database connection and creates a reference to each collection (table) that is needed
 *
 * @param host The host address of the database (e.g. localhost)
 * @param port The port on which the database listens (MongoDB defaults to 27017)
 */
class MongoDBClient (host: String, port: Int) {
    // Creates a connection to the "realtime_chat" database on the specified host and port
    val conn = KMongo.createClient(host, port).getDatabase("realtime_chat")
    // Gets and object for operating on the "users" table
    val users = conn.getCollection<MDBUser>("users")
    // Gets and object for operating on the "chats" table
    val chats = conn.getCollection<MDBChat>("chats")
    // Gets and object for operating on the "messages" table
    val messages = conn.getCollection<MDBMessage>("messages")
}