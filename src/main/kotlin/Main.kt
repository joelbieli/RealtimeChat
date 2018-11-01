import mu.KotlinLogging

val mdbcl = MongoDBClient("localhost", 27017) // immutable instance of MongoDBClient - the database connection
val jls = JavalinServer(7070) // immutable instance of JavalinServer - launches the webserver
val logger = KotlinLogging.logger {} // simple logger for printing possible problems in the program

fun main(args: Array<String>) {
    logger.info("Program stared")
}