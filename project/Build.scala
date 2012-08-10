import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "Cube"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
      "mysql" % "mysql-connector-java" % "5.1.21",
      "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
      "com.google.code.gson" % "gson" % "2.2.2"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
        ebeanEnabled := false
    )

}
