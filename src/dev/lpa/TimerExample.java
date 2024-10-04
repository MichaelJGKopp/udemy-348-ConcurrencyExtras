package dev.lpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TimerExample {

  public static void main(String[] args) {

//    Timer timer = new Timer(); // constructs Timer Thread

    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        String threadName = Thread.currentThread().getName();
        DateTimeFormatter formatter =
          DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(threadName + " Timer task executed at: " +
          formatter.format(LocalDateTime.now()));
      }
    };

//    timer.scheduleAtFixedRate(task, 0, 2_000); // in ms

    var executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
    // TimerTask implements Runnable interface, but can not use Runnable in Timer instance method

    try {
      Thread.sleep(12_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {

//    timer.cancel();
      executor.shutdown();
    }
  }
}
