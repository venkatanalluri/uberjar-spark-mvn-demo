/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

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
