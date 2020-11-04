package com.gitee.saas.common.context;

/**
 * 常量工具类
 *
 * @author jie
 * @date 2019/12/21
 */
public class BaseContextConstants {

    /**
     * JWT中封装的 用户id
     */
    public static final String JWT_KEY_USER_ID = "userid";
    /**
     * JWT中封装的 用户名称
     */
    public static final String JWT_KEY_NAME = "name";
    /**
     * JWT中封装的 token 类型
     */
    public static final String JWT_KEY_TOKEN_TYPE = "token_type";
    /**
     * JWT中封装的 用户账号
     */
    public static final String JWT_KEY_ACCOUNT = "account";

    /**
     * JWT中封装的 客户端id
     */
    public static final String JWT_KEY_CLIENT_ID = "client_id";


    /**
     * JWT token 签名
     * <p>
     * 签名密钥长度至少32位
     */
    public static final String JWT_SIGN_KEY = "com_github_saas_common_jwt_token";

    /**
     * JWT中封装的 租户编码
     */
    public static final String JWT_KEY_TENANT = "tenant";
    /**
     * 刷新 Token
     */
    public static final String REFRESH_TOKEN_KEY = "refresh_token";

    /**
     * User信息 认证请求头
     */
    public static final String BEARER_HEADER_KEY = "token";
    /**
     * User信息 认证请求头前缀
     */
    public static final String BEARER_HEADER_PREFIX = "Bearer ";
    /**
     * User信息 认证请求头前缀
     */
    public static final String BEARER_HEADER_PREFIX_EXT = "Bearer%20";

    /**
     * Client信息认证请求头
     */
    public static final String BASIC_HEADER_KEY = "Authorization";

    /**
     * Client信息认证请求头前缀
     */
    public static final String BASIC_HEADER_PREFIX = "Basic ";

    /**
     * Client信息认证请求头前缀
     */
    public static final String BASIC_HEADER_PREFIX_EXT = "Basic%20";


    /**
     * token
     */
    @Deprecated
    public static final String TOKEN_NAME = BEARER_HEADER_KEY;

}
