package domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户登录信息
 */
@Getter
@Setter
public class LoginInfo extends BaseDomain{

    //正常
    public static final int STATE_NORMAL = 0;
    //锁定
    public static final int STATE_LOCK = 1;

    private String username;
    private String password;
    private int state;


}
