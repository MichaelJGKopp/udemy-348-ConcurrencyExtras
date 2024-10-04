package dev.lpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {

  public static void main(String[] args) {

    Timer timer = new Timer();

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

    timer.scheduleAtFixedRate(task, 0, 2_000); // in ms

    try {
      Thread.sleep(12_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    timer.cancel();
  }
}
