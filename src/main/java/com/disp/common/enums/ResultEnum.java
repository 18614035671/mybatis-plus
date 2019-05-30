package com.disp.common.enums;

/**
 * 返回数据枚举
 */
public enum ResultEnum {

    SUCCESS(1, "操作成功"),
    FAILED(99999, "出错啦，请联系管理员解决问题！"),
    TOKEN_EMPTY_ERROR(10001, "token不能为空"),
    TOKEN_INVALID_ERROR(10002, "token无效"),

    LOGIN_FAILED_ERROR(11001, "登录失败"),
    VERIFY_CODE_ERROR(11002, "验证码错误"),
    ARGUMENT_ERROR(11003, "请求参数错误"),
    MAX_VERIFY_CODE_ERROR_TIMES(110004, "验证码错误次数已达上限"),
    FORBIDDEN_ERROR(110005, "没有相关操作权限"),
    OUT_OF_TTIME_SEND_VERIFY(110006, "30s内重复发送短信"),
    INVALID_VERIFY(110007, "验证码失效"),

    LOGIN_NO_MOBILE(11008, "手机号不能为空"),
    LOGIN_MOBILE_ERROR(11009, "手机号格式不正确"),
    LOGIN_MOBILE_EXISES(11010, "当前手机号已注册，请直接登录"),
    LOGIN_MOBILE_NOEXISES(110011, "您的账号不存在,请检查号码是否正确或联系主管"),
    LOGIN_MOBILE_LOCK(110012, "手机号用户已离职或账户被锁住");

    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ResultEnum getEnum(Integer code) {
        for (ResultEnum scene : ResultEnum.values()) {
            if (scene.getCode() == code.intValue()) {
                return scene;
            }
        }
        return null;
    }
}

