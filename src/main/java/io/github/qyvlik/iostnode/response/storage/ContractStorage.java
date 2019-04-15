package io.github.qyvlik.iostnode.response.storage;

import com.alibaba.fastjson.annotation.JSONField;

public class ContractStorage {

    @JSONField(name = "data")
    private String data;

    @JSONField(name = "block_hash")
    private String blockHash;

    @JSONField(name = "block_number")
    private Long blockNumber;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public Long getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(Long blockNumber) {
        this.blockNumber = blockNumber;
    }

    @Override
    public String toString() {
        return "ContractStorage{" +
                "data='" + data + '\'' +
                ", blockHash='" + blockHash + '\'' +
                ", blockNumber=" + blockNumber +
                '}';
    }
}

