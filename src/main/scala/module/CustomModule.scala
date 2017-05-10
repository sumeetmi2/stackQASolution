package module

import com.google.inject.{AbstractModule, TypeLiteral}
import helpers._

/**
  * Created by ssharma on 5/10/17.
  */
class CustomModule extends  AbstractModule{
  override def configure(): Unit = {

    bind(classOf[PlayerRepository[FootballPlayer]]).to(classOf[FootballMongoRepo])

    bind(classOf[PlayerDAO[FootballPlayer]]).to(classOf[MongoPlayerDAO[FootballPlayer]])
    bind(classOf[PlayerDAO[VideoGamePlayer]]).to(classOf[MongoPlayerDAO[VideoGamePlayer]])
  }
}
