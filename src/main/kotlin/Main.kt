import mu.KotlinLogging
import utils.sign
import utils.verify

val mdbcl = MongoDBClient("localhost", 27017)
val jls = JavalinServer(7070)
val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    val test = verify(sign(""))
    println("sup")
}