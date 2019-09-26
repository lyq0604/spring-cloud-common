package com.blade.common.domain;

import lombok.Data;

import java.util.List;

/**
 * jwt token entity
 *
 * @author lyq
 * @create 8/31/19
 */
@Data
public class JWT {

    private String access_token;

    private String token_type;

    private String refresh_token;

    private Long expires_in;

    private String scope;

    private String jti;

    private List authorities;

    private String userId;

}
