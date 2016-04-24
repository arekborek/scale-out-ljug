package pl.ljug.scaleout.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "_user")
public class User {

    private @Id @Getter String login;
    private String passwordHash;
    private String role;

}
