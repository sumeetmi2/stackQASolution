package helpers

import play.api.libs.json.{OWrites, Reads, __}
import play.api.libs.functional.syntax._

/**
  * Created by ssharma on 5/10/17.
  */
case class VideoGamePlayer(var _id:Option[String], gameId: String, personalDetails: String) extends Player
object VideoGamePlayer{
  implicit lazy val videoGamePlayerReads: Reads[VideoGamePlayer] = (
    (__ \ "_id").readNullable[String] and
      (__ \ "gameId").read[String] and
      (__ \ "personalDetails").read[String]
    ) (VideoGamePlayer.apply _)

  implicit lazy val videoGamePlayerWrites: OWrites[VideoGamePlayer] = (
    (__ \ "_id").writeNullable[String] and
      (__ \ "gameId").write[String] and
      (__ \ "personalDetails").write[String]
    ) (unlift(VideoGamePlayer.unapply))
}
