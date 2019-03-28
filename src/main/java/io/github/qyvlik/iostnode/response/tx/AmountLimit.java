package io.github.qyvlik.iostnode.response.tx;

import com.alibaba.fastjson.annotation.JSONField;

public class AmountLimit {
    @JSONField(name = "token")
    private String token;           // token 名字

    @JSONField(name = "value")
    private String value;           // 这种 token 对应的限额

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AmountLimit{" +
                "token='" + token + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
