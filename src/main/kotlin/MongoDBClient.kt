import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import user.User

class MongoDBClient (host: String, port: Int) {
    val conn = KMongo.createClient(host, port).getDatabase("realtime_chat")
    val users = conn.getCollection<User>()

    init {

    }
}