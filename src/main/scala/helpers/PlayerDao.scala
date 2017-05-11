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


class MongoPlayerDAO[T <: Player] @Inject()(injector: Injector) extends PlayerDAO[T] {

  val playerRepository = injector.instanceOf(classOf[PlayerRepository[T]])
  def findById(_id: String): Future[Option[T]] = playerRepository.findById(_id)

  def insert(t: T): Future[T] = playerRepository.insert(t).map(_ => t)

}
