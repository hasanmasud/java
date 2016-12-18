package online.smartcompute.tutorial.test.junit4.demo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Demo3 {
    public static void main(String[] args) {
          Result result = JUnitCore.runClasses(Demo2.class);
          for (Failure failure : result.getFailures()) {
             System.out.println(failure.toString());
          }
          System.out.println(result.getRunCount() + " testecase executed in " + result.getRunTime() + " millisecond");
          System.out.println(result.wasSuccessful());
       }
}