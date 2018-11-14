package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String account;
    private String password;
    private String name;
    private String identityId;
    private String sex;
    private String tel;
    private String email;
    private String address;

}
