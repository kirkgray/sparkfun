package com.pearson.sparksummit

import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._

object SummitEx {

  def main( args: Array[String]) { 
    
	  val ssc = new StreamingContext("local", "seer-activity", Seconds(10))
	  
	  val messages = null//KafkaUtils.createStream( ssc, "localhost:2181", "test", Map("test" -> 1) ).map(_._2)
	  /*
	  val vStream = messages.map( m => { m.toString() } )
	  
	  //split the words and mash them into the words list such that each line and the splits are all just words
	  val words = vStream.flatMap( _.split(" ") ) 
	  
	  val pairs = words.map(word => (word, 1))
	  val wordCounts = pairs.reduceByKey(_ + _)

	  wordCounts.print()
	  
	  ssc.start()
	  	  
	  ssc.awaitTermination()
	  * 
	  */
  }
}