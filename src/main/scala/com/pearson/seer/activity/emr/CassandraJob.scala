package com.pearson.seer.activity.emr

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

import com.datastax.spark.connector._

/*
 * This example demonstrates using Spark with Cassandra with the New Hadoop API and Cassandra
 * support for Hadoop.
 *
 * To run this example, run this file with the following command params -
 * <spark_master> <cassandra_node> <cassandra_port>
 *
 * So if you want to run this on localhost this will be,
 * local[3] localhost 9160
 *
 * The example makes some assumptions:
 * 1. You have already created a keyspace called casDemo and it has a column family named Words
 * 2. There are column family has a column named "para" which has test content.
 *
 * You can create the content by running the following script at the bottom of this file with
 * cassandra-cli.
 *
 */
object CassandraJob {

  def main(args: Array[String]) {

    val conf = new SparkConf(true).set("spark.cassandra.connection.host", "127.0.0.1")

    val sc = new SparkContext("local", "test", "conf")
    
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    
    import sqlContext.createSchemaRDD

    val rdd = sc.cassandraTable("activitycqlks", "event")
    	//.where( "bucket_key = ?", 2 )
    	.where( "bucket_key = ? and event_time = ?", 1, "41796b10-11fa-11e4-a30e-68a86d275b2c" )
    
    println(rdd.count)
    //println(rdd.first)

    //print( rdd.count() )
  }
}
