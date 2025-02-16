import java.util.Date;

public class StopWatch {
   private Date startTime;
   private Date endTime;

   public StopWatch() {
        this.startTime = new Date();
   }

   public void start() {
       this.startTime = new Date();
   }

    public void stop() {
        this.endTime = new Date();
    }

    public long getElapsedTime() {
       this.endTime = new Date();
       return this.endTime.getTime() - this.startTime.getTime();
    }
}
