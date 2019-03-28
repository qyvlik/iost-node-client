package io.github.qyvlik.iostnode.response.storage;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class ContractStorageFields {
    @JSONField(name = "fields")
    private List<String > fields;

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "ContractStorageFields{" +
                "fields=" + fields +
                '}';
    }
}
