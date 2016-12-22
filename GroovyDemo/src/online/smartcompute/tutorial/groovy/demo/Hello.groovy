package com.smartcompute.groovy.demo
@RestController
class GreetingController{
	@RequestMapping("/hi/{name}")
	def hi(@PathVariable String name){
		[greet:"Hello, " + name]
	}
}