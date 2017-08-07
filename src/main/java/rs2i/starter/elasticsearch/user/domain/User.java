package rs2i.starter.elasticsearch.user.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(indexName= "userindex", type = "users")
public class User {
    @Id
    private String id;
    private String userName;
    private String password;
}
