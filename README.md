ÜberJAR Spark Demo
==================

Demo project which shows how to embed dependencies into spark application.
This is a version of original [Spark Pi Example](https://github.com/apache/spark/blob/master/examples/src/main/scala/org/apache/spark/examples/SparkPi.scala), but using a Twitter Algebird library.

## Building

    mvn clean package

## Running on Spark

To run on YARN:

    spark-submit --master yarn-client --class com.avira.uberjar.Pi uberjar-spark-demo-assembly-1.0.jar 100

## Useful links
 - [Submitting Applications in Spark](https://spark.apache.org/docs/latest/submitting-applications.html)
 - [sbt-assembly plugin](https://github.com/sbt/sbt-assembly#using-published-plugin)

