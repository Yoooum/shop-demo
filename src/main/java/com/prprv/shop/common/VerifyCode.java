package com.prprv.shop.common;

import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 未確認の庭師
 */
public class VerifyCode {
    // 单例模式
    private volatile static VerifyCode instance;
    private VerifyCode() {}
    public static VerifyCode getInstance() {
        if (instance == null) {
            synchronized (VerifyCode.class) {
                if (instance == null) {
                    instance = new VerifyCode();
                }
            }
        }
        return instance;
    }

    // 验证码和过期时间
    private final Map<String, Long> codeMap = new HashMap<>();
    // 生成验证码
    public String generateCode(String email) {
        // 加盐
        String salt = "(ᗜ‸ᗜ)" + (Math.random() * 9 + 1) * 10000;
        // 生成验证码，取其中10位
        return DigestUtils.md5DigestAsHex((salt + email).getBytes()).substring(10, 20).toUpperCase();
    }

    // 私有方法，存储验证码
    private void setExpireTime(String code,Integer minute) {
        codeMap.put(code, System.currentTimeMillis() + minute * 60 * 1000);
    }

    /**
     * 邮箱加密生成验证码，设置过期时间
     * @param email  邮箱
     * @param expireMinute 过期时间(分钟)
     * @return 验证码
     */
    public String generate(String email, Integer expireMinute) {
        String code = generateCode(email);
        setExpireTime(code, expireMinute);
        return code;
    }

    // 测试用
    public Map<String, Long> getMap() {
        return codeMap;
    }

    /**
     * 验证验证码是否过期并移除过期验证码
     * @param code 验证码
     * @return true:未过期 false:已过期
     */
    public boolean verify(String code) {
        removeExpireCode();
        return codeMap.containsKey(code);
    }

    // 遍历map的时间，移除过期验证码(遍历时删除，需要使用迭代器)
    private void removeExpireCode() {
        codeMap.entrySet().removeIf(entry -> entry.getValue() < System.currentTimeMillis());
    }

}
