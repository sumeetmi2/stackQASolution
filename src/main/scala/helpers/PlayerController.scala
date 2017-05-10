package helpers

import com.google.inject.Inject
import play.api.inject.Injector
import play.api.libs.json.Json
import play.api.mvc._
import helpers.FootballPlayer._
import helpers.VideoGamePlayer._
import scala.concurrent.ExecutionContext.Implicits.global


/**
  * Created by ssharma on 5/10/17.
  */
class PlayerController @Inject() (injector: Injector) extends Controller{

  val footballPlayerService = injector.instanceOf(classOf[PlayerService[FootballPlayer]])
  val videoGamePlayerService = injector.instanceOf(classOf[PlayerService[VideoGamePlayer]])
  def run: EssentialAction = Action.async {
  r =>
    footballPlayerService.findById("as").map{
      x => Ok(Json.toJson(x.get))
    }
  }
}
