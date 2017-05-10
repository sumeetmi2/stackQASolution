logLevel := Level.Warn

resolvers ++= Seq(
  Resolver.sonatypeRepo("public"),
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.10")