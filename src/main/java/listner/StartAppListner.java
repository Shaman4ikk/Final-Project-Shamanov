package listner;

import db.DBManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class StartAppListner implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        DBManager dbManager = DBManager.getInstance();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> scheduledFuture =
                scheduledExecutorService.schedule(
                        dbManager::setDebt,
                        1,
                        TimeUnit.DAYS
                );
    }
}
