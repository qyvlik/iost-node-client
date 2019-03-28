package io.github.qyvlik.iostnode.request;

import com.alibaba.fastjson.annotation.JSONField;

public class GetContractStorageRequest {
    @JSONField(name = "id")
    private String id;                      // 智能合约的ID

    @JSONField(name = "field")
    private String field;                   // 从StateDB中得到值，如果StateDB[key]是一个map,那么需要设置field(可以得到StateDB[key][field]的值)

    @JSONField(name = "key")
    private String key;                     // StateDB的key

    @JSONField(name = "by_longest_chain")
    private Boolean byLongestChain;         // true - 从最长链得到数据，false - 从不可逆块得到数据

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getByLongestChain() {
        return byLongestChain;
    }

    public void setByLongestChain(Boolean byLongestChain) {
        this.byLongestChain = byLongestChain;
    }

    @Override
    public String toString() {
        return "GetContractStorageRequest{" +
                "id='" + id + '\'' +
                ", field='" + field + '\'' +
                ", key='" + key + '\'' +
                ", byLongestChain=" + byLongestChain +
                '}';
    }
}
