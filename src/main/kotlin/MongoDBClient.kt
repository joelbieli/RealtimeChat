import chat.MDBChat
import message.MDBMessage
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import user.MDBUser

class MongoDBClient (host: String, port: Int) {
    val conn = KMongo.createClient(host, port).getDatabase("realtime_chat")
    val users = conn.getCollection<MDBUser>("users")
    val chats = conn.getCollection<MDBChat>("chats")
    val messages = conn.getCollection<MDBMessage>("messages")
}