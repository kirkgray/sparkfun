package com.pearson.seer.activity

object TestFlatMap {

  def main( args: Array[String]) { 
    
    //input two n digit numbers x and y
    //output
	println( intMult( 2, 3 ) )
	println( intMult( 5678, 1234 ) )
	println( karatsubaMult( 5678, 1234 ) )
	
	println( theirMergeSort( List( 5, 4, 1, 8, 7, 2, 6, 3 ) ) )
  }
  
  def intMult( x: Int, y: Int ) : Int = {
    
    return x * y
  }
  
  def karatsubaMult( x: Int, y: Int ) : Int = {
    
    //x = ( 10 ^ n/2 * a ) + b
    //y = ( 10 ^ n/2 * c ) + d
    //xy = (10 ^ n * a * c) + 
    //     10 ^ n/2 * ( ad + bc) + bd
    
    //recursively compute ac, ad, bc, bd, then compute
    // * in the straightforward way
    
    //base case, if numerals have 1 digit each, 
    //just return product
    
    //step 1: recursively compute ac
    // 2 : recursively compute bd
    // 3 : recursively compute ( a + b ) * (c + d) = ac + ad + bc + bd
    // 4 gauss' trick = 3 - 1 - 2 = ad + bc
    
    return 0
  }
  
  def theirMergeSort( xs: List[Int] ) : List[Int] = {
    
    println( xs )
    val n = xs.length / 2
	  if (n == 0) {
	    println( "basecase!" )
	    return xs
	  } 
	  else {
	    def merge(xs: List[Int], ys: List[Int]): List[Int] =
	        (xs, ys) match {
	        case(Nil, ys) => ys
	        case(xs, Nil) => xs
	        case(x :: xs1, y :: ys1) => 
	          if (x < y) x :: merge(xs1, ys)
	          else y :: merge(xs, ys1)
	    }
	    val (left, right) = xs.splitAt(n)
	    return merge(theirMergeSort(left), theirMergeSort(right))
	  }
  }
  
  /*
  def mergeSort( listIn : List[Int] ) : List[Int] = {
    
    var listC = List()
    
    //break in two
    val listA = listIn.slice( 0, (listIn.size / 2) )
    val listB = listIn.slice( listIn.size / 2, listIn.size )
    
    var i = 0
    var j = 0
    
    for( k <- 0 to listIn.size ) {
      
    }
    
    return Nil
  }
   */
  
}