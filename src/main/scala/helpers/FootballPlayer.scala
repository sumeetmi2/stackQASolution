package helpers

import play.api.libs.functional.syntax._
import play.api.libs.functional.syntax.unlift
import play.api.libs.json.{OWrites, Reads, __}

/**
  * Created by ssharma on 5/10/17.
  */
case class FootballPlayer(var _id:Option[String], gameId: String, personalDetails: String) extends Player

object FootballPlayer{
  implicit lazy val footballPlayerReads: Reads[FootballPlayer] = (
    (__ \ "_id").readNullable[String] and
      (__ \ "gameId").read[String] and
      (__ \ "personalDetails").read[String]
    ) (FootballPlayer.apply _)

  implicit lazy val footballPlayerWrites: OWrites[helpers.FootballPlayer] = (
    (__ \ "_id").writeNullable[String] and
      (__ \ "gameId").write[String] and
      (__ \ "personalDetails").write[String]
    ) (unlift(FootballPlayer.unapply))

}
