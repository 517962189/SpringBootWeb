package czhy.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TestScheduled {

    @Scheduled(cron = "0 0/1 * * * ?")
    public void test() {
        System.out.println("Test Scheduled");
    }
}
