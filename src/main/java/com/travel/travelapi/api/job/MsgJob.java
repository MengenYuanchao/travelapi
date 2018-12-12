package com.travel.travelapi.api.job;

import com.travel.travelapi.utils.JobConstUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.ConcurrentMap;

public class MsgJob {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "0 0/1 * * * ?")
    public void checkMsgCodeJob() {
        logger.info("定时清理短信验证码");
        ConcurrentMap<String, String[]> codeMap = JobConstUtils.msgCodeMap;
        String[] code = null;

        long time = System.currentTimeMillis();
        for (String key : codeMap.keySet()) {
            code = codeMap.get(key);
            long times = Long.parseLong(code[1]);
            long second = ((time - times) / 1000);
            if (second >= 1800) {
                JobConstUtils.msgCodeMap.remove(key);
            }
        }
    }
}
