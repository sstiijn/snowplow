/*
 * Copyright (c) 2012-2015 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
lazy val root = project.in(file("."))
  .settings(
    organization  :=  "com.snowplowanalytics",
    name          :=  "snowplow-stream-enrich",
    version       :=  "0.10.0",
    description   :=  "The Snowplow Enrichment process, implemented as an Amazon Kinesis app",
    scalaVersion  :=  "2.10.1",
    scalacOptions :=  BuildSettings.compilerOptions,
    javacOptions  :=  BuildSettings.javaCompilerOptions,
    resolvers     ++= Dependencies.resolutionRepos,
    shellPrompt   := { _ => "stream-enrich> " }
  )
  .settings(BuildSettings.scalifySettings)
  .settings(BuildSettings.sbtAssemblySettings)
  .settings(
    libraryDependencies ++= Seq(
      // Java
      Dependencies.Libraries.kinesisSdk,
      Dependencies.Libraries.dynamodbSdk,
      Dependencies.Libraries.s3Sdk,
      Dependencies.Libraries.kinesisClient,
      Dependencies.Libraries.kafkaClients,
      Dependencies.Libraries.commonsCodec,
      Dependencies.Libraries.config,
      Dependencies.Libraries.slf4j,
      Dependencies.Libraries.log4jOverSlf4j,
      // Scala
      Dependencies.Libraries.scopt,
      Dependencies.Libraries.scalaz7,
      Dependencies.Libraries.json4s,
      Dependencies.Libraries.json4sJackson,
      Dependencies.Libraries.snowplowRawEvent,
      Dependencies.Libraries.snowplowCommonEnrich,
      Dependencies.Libraries.igluClient,
      Dependencies.Libraries.snowplowTracker,
      // Test
      Dependencies.Libraries.specs2,
      Dependencies.Libraries.scalacheck
    )
  )
