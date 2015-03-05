package com.avira.uberjar


import com.twitter.algebird.Operators._
import org.apache.spark._

/**
 * Created by Viacheslav Rodionov (viacheslav.rodionov@avira.com) on 19/02/15.
 */
object Pi extends App {
  val NUM_SAMPLES = args(0).toInt

  val conf = new SparkConf().setAppName("Uber Jar Pi Demo")
  val sc: SparkContext = new SparkContext(conf)
  val count: Int = sc.parallelize(1 to NUM_SAMPLES).map { i =>
    val point = (math.random, math.random)
    val square = (point * point)
    println(square._1)
    if (square._1 + square._2 < 1.0) 1 else 0
  }.reduce(_ + _)
  println("Pi is roughly " + 4.0 * count / NUM_SAMPLES)
  sc.stop
}
