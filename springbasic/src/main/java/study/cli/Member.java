package study.cli;

import lombok.*;

@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {

    private  int id;
    @NonNull private String username;
    @NonNull private String password;


    @Override
    public String toString() {
        return "id: " + id + ", username: " + username + ", password : " + password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Member(int id) {
        this.id = id;
    }
}
