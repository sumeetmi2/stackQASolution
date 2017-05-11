package module

import com.google.inject.name.Names
import com.google.inject.{AbstractModule, TypeLiteral}
import helpers._

/**
  * Created by ssharma on 5/10/17.
  */
class CustomModule extends  AbstractModule{
  override def configure(): Unit = {
    bind(classOf[PlayerRepository[FootballPlayer]]).toInstance(new FootballMongoRepo())
    bind(classOf[PlayerRepository[VideoGamePlayer]]).annotatedWith(Names.named("videogameRepo"))toInstance(new VideoGameMongoRepo())
    bind(classOf[PlayerDAO[FootballPlayer]]).to(classOf[MongoPlayerDAO[FootballPlayer]])
    bind(classOf[PlayerDAO[VideoGamePlayer]]).to(classOf[MongoPlayerDAO[VideoGamePlayer]])
  }
}
