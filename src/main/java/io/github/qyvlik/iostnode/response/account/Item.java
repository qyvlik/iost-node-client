package io.github.qyvlik.iostnode.response.account;

import com.alibaba.fastjson.annotation.JSONField;

public class Item {
    /**
     * 权限名字或者key pair id
     */
    @JSONField(name = "id")
    private String id;

    /**
     * true - id是key pair, false - id为权限名字
     */
    @JSONField(name = "is_key_pair")
    private Boolean isKeyPair;

    /**
     * 权限权重
     */
    @JSONField(name = "weight")
    private Long weight;

    /**
     * 权限
     */
    @JSONField(name = "permission")
    private String permission;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getKeyPair() {
        return isKeyPair;
    }

    public void setKeyPair(Boolean keyPair) {
        isKeyPair = keyPair;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", isKeyPair=" + isKeyPair +
                ", weight=" + weight +
                ", permission='" + permission + '\'' +
                '}';
    }
}
