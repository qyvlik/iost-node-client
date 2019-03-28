package io.github.qyvlik.iostnode.request;

import com.alibaba.fastjson.annotation.JSONField;

public class GetContractStorageFieldsRequest {
    @JSONField(name = "id")
    private String id;                      // 智能合约的ID
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
        return "GetContractStorageFieldsRequest{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", byLongestChain=" + byLongestChain +
                '}';
    }
}
