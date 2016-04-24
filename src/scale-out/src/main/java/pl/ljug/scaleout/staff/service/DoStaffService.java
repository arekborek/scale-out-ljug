package pl.ljug.scaleout.staff.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DoStaffService {

    private final Random random = new Random();

    @SneakyThrows
    public Long doStaff() {
        Thread.sleep((long) Math.max(random.nextInt(50), random.nextInt(100))); //sleep from 0,5 to 1 second
        return random.nextLong();
    }

}
