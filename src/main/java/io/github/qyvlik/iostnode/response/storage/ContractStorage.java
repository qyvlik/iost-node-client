package io.github.qyvlik.iostnode.response.storage;

import com.alibaba.fastjson.annotation.JSONField;

public class ContractStorage {

    @JSONField(name = "data")
    private String data;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ContractStorage{" +
                "data='" + data + '\'' +
                '}';
    }
}

