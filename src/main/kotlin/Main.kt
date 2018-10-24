import mu.KotlinLogging

val mdbcl = MongoDBClient("localhost", 27017)
val jls = JavalinServer(7070)
val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    println("sup")
}