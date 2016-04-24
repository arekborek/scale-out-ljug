package pl.ljug.scaleout.request;

import lombok.*;
import pl.ljug.scaleout.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestLog {

    private @Id @GeneratedValue @Getter Long id;
    private String pid;
    private String threadId;
    private final Date time = new Date();
    private Long counter;
    private Long duration;
    private @ManyToOne User user;

}
