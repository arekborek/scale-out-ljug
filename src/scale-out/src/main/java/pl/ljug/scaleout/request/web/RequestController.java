package pl.ljug.scaleout.request.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ljug.scaleout.request.service.RequestLogService;
import pl.ljug.scaleout.staff.service.DoStaffService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.String.format;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RequestController {

    private final AtomicLong requestCounter = new AtomicLong(0);
    private final @NonNull RequestLogService requestLogService;
    private final @NonNull DoStaffService doStaffService;

    @RequestMapping(path = "ping")
    public @ResponseBody String ping() {
        return format("request info is: %s\n",
                requestLogService.log(
                        requestCounter.incrementAndGet(),
                        logDuration(doStaffService::doStaff)
                )
        );
    }

    @RequestMapping(path = "ping2")
    public @ResponseBody String ping2() {
        String response = format("request number: %s, take: %s\n", requestCounter.incrementAndGet(), logDuration(
                () -> {
                    doStaffService.doStaff();
                    return -1L;
                }
        ));

        System.out.print(response);
        return response;
    }

    @SneakyThrows
    private <T> Long logDuration(Callable<T> callable) {
        Temporal start = LocalDateTime.now();
        callable.call();
        return Duration.between(start, LocalDateTime.now()).toMillis();
    }



}
