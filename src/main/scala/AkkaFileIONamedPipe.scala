import akka.stream._
import akka.stream.scaladsl._

import akka.{ NotUsed, Done }
import akka.actor.ActorSystem
import akka.util.ByteString
import scala.concurrent._
import scala.concurrent.duration._
import java.nio.file.Paths

object AkkaFileIONamedPipe extends App {
  private implicit val system = ActorSystem("AkkaFileIONamedPipe")
  private implicit val materializer = ActorMaterializer()
  private implicit val ec = system.dispatcher

  FileIO.fromPath(Paths.get("/tmp/some-fifo")) // Create this file with `mkfifo /tmp/some-fifo`.
    .to(Sink.ignore)
    .run()
    .onComplete(_ ⇒ system.terminate())
}
