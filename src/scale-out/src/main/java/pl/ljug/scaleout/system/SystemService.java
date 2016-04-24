package pl.ljug.scaleout.system;

import org.springframework.stereotype.Service;

@Service
public class SystemService {

    private final String pid;

    public SystemService() {
        this.pid = System.getProperties().getProperty("PID");
    }

    public String getPid() {
        return pid;
    }

    public String getThreadId() {
        return "" + Thread.currentThread().getId();
    }
}
