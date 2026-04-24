package com.kh.app.security.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVo {

    private String username;
    private String password;
    private String role;

}
