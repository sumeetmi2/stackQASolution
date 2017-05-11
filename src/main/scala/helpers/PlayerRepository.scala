package helpers

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by ssharma on 5/11/17.
  */

trait PlayerRepository[T]{
  def findById(_id: String): Future[Option[T]]
  def insert(t: T): Future[T]
}


trait MongoRepository[T <: Player] extends PlayerRepository[T]{

}

class FootballMongoRepo extends PlayerRepository[FootballPlayer]{
  override def findById(_id: String): Future[Option[FootballPlayer]]
  = Future.successful(Option(new FootballPlayer(None, "1","2")))

  override def insert(t: FootballPlayer): Future[FootballPlayer] = Future(t)

}

class VideoGameMongoRepo extends PlayerRepository[VideoGamePlayer]{
  override def findById(_id: String): Future[Option[VideoGamePlayer]]
  = Future.successful(Option(new VideoGamePlayer(Some("222"), "5","6")))

  override def insert(t: VideoGamePlayer): Future[VideoGamePlayer] = Future(t)
}