package com.blade.common.domain;

import lombok.Data;

import java.util.List;

/**
 * @author lyq
 * @create 8/15/19
 */
@Data
public class UserInfo {

    private String id;

    private String username;

    private String password;

    private List<String> roles;

}
