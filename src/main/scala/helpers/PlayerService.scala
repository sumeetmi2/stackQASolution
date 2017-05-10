package helpers

import com.google.inject.Inject
import play.api.inject.Injector

import scala.concurrent.Future

/**
  * Created by ssharma on 5/10/17.
  */
class PlayerService[T <: Player] @Inject()(injector: Injector){

  val playerDAO = injector.instanceOf(classOf[PlayerDAO[T]])
  def findById(_id: String): Future[Option[T]] = playerDAO.findById(_id)


  def save(t: T): Future[T] = playerDAO.insert(t)

}
