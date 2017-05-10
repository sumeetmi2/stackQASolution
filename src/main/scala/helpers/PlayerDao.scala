package helpers

import com.google.inject.Inject
import play.api.inject.Injector

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by ssharma on 5/10/17.
  */
trait PlayerDAO[T <: Player]{
  def findById(_id: String): Future[Option[T]]

  def insert(t: T): Future[T]

}

trait PlayerRepository[T<: Player]{
  def findById(_id: String): Future[Option[T]]
  def insert(t: T): Future[T]
}


trait MongoRepository[T <: Player] extends PlayerRepository[T]{

}

class FootballMongoRepo extends PlayerRepository[FootballPlayer] with MongoRepository[FootballPlayer]{
  override def findById(_id: String): Future[Option[FootballPlayer]]
  = Future.successful(Option(new FootballPlayer(None, "1","2")))

  override def insert(t: FootballPlayer): Future[FootballPlayer] = Future(t)
}

class VideoGameMongoRepo extends PlayerRepository[VideoGamePlayer] with MongoRepository[VideoGamePlayer]{
  override def findById(_id: String): Future[Option[VideoGamePlayer]]
  = Future.successful(Option(new VideoGamePlayer(Some("222"), "5","6")))

  override def insert(t: VideoGamePlayer): Future[VideoGamePlayer] = Future(t)
}

class MongoPlayerDAO[T <: Player] @Inject()(injector: Injector) extends PlayerDAO[T] {

  val playerRepository = injector.instanceOf(classOf[PlayerRepository[T]])
  def findById(_id: String): Future[Option[T]] = playerRepository.findById(_id)

  def insert(t: T): Future[T] = playerRepository.insert(t).map(_ => t)

}
