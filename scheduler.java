public class SchedulerTimer implements ServletContextListener {
    private volatile ScheduledExecutorService executor;
 
    public void contextInitialized(ServletContextEvent sce)
    {
      
        executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(new SchedulerUpdate(), 0, 1, TimeUnit.HOURS);
    //ScheduledThreadPoolExecutor 다음 4개의 메소드들을 제공합니다.

    //schedule(Runnable command, long delay, TimeUnit unit) : 작업을 일정 시간 뒤에 한번 실행합니다.
    //schedule(Callable command, long delay, TimeUnit unit) : 작업을 일정 시간 뒤에 한번 실행하고, 그 결과를 리턴합니다.
    //scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) : 작업을 일정 시간 간격으로 반복적으로 실행시킵니다.
    //scheduleWithFixedDelay(Runnable command, long initialDelay, long period, TimeUnit unit) : 작업이 완료되면 일정 시간 뒤에 다시 실행시킵니다. scheduleAtFixedRate()와 다른 점은 작업 종료시점이 기준이라는 것입니다.
    }
 
    public void contextDestroyed(ServletContextEvent sce)
    {
        final ScheduledExecutorService executor = this.executor;
 
        if (executor != null)
        {
           
            executor.shutdown();
            this.executor = null;
        }
    }
}


//web.xml 에 listener 추가
 <listener>
       <listener-class>com.vizensoft.scheduler.SchedulerTimer</listener-class>
   </listener>
