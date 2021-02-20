package com.hello.way.project.biz.common.log;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.concurrent.*;

/**
 * 线程池工具类
 */
public class ThreadPools {

  private ExecutorService logPool;

  private ThreadPools() {
    logPool = new ThreadPoolExecutor(1, 8, 15, TimeUnit.MINUTES,
        new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("LOGGER",true));
  }

  public static ThreadPools getInstance() {
    return ThreadPoolManagerHolder.instance;
  }

  public void submitLoggerTask(Runnable task) throws RejectedExecutionException {
    logPool.submit(task);
  }

  private static class ThreadPoolManagerHolder {

    private static ThreadPools instance = new ThreadPools();
  }


  public void shutdown() {
    logPool.shutdown();
  }
}
