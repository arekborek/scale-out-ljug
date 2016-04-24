package pl.ljug.scaleout.request.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ljug.scaleout.request.RequestLog;

public interface RequestLogRepository extends JpaRepository<RequestLog, Long> {
}
