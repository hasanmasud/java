package com.smartcompute.groovy.demo

class Example1 {
	static void main(String[] args){
		def clos = {println "helo world"};
		clos.call();
		
		
		def clos1 = {param -> println "hellp $param"};
		clos1.call("world");
		
		
		
		
		def makeClos = {
			def name="masud"
			return{
				println "my name id ${name}"
			}
		}
		def cls = makeClos();
		cls();
		
		
		
		
		def createGreeter = { name ->
			return {
			  def day = new Date().getDay()
			  if (day == 0 || day == 1) {
				println "Nice Weekend, $name"
			  } else {
				println "Hello, $name"
			  }
			}
		  }
		  def greetWorld = createGreeter("World")
		  greetWorld()
		
		
		
		
	}
}
