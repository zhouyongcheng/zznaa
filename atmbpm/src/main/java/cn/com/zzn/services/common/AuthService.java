package cn.com.zzn.services.common;

import cn.com.zzn.common.models.TokenInfo;

/**
 * Created by cmwin on 10/10/15.
 */
public interface AuthService {

    String createJsonWebToken(String userId, Long durationDays);

    TokenInfo verifyToken(String token);
}
