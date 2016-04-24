package pl.ljug.scaleout.request.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ljug.scaleout.request.RequestLog;
import pl.ljug.scaleout.request.persistance.RequestLogRepository;
import pl.ljug.scaleout.security.LoggedUserGetter;
import pl.ljug.scaleout.system.SystemService;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RequestLogService {

    private final @NonNull RequestLogRepository requestLogRepository;
    private final @NonNull SystemService systemService;
    private final @NonNull LoggedUserGetter loggedUserGetter;

    public RequestLog log(Long counter, Long duration) {
        RequestLog log = RequestLog.builder()
                .pid(systemService.getPid())
                .threadId(systemService.getThreadId())
                .counter(counter)
                .duration(duration)
                .user(loggedUserGetter.getLoggedUser())
                .build();
        return requestLogRepository.save(log);
    }

}
