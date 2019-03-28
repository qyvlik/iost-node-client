package io.github.qyvlik.iostnode.response.contract;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.qyvlik.iostnode.response.tx.AmountLimit;

import java.util.List;

public class ABI {
    @JSONField(name = "name")
    private String name;

    @JSONField(name = "args")
    private List<String> args;

    @JSONField(name = "amount_limit")
    private List<AmountLimit> amountLimit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public List<AmountLimit> getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(List<AmountLimit> amountLimit) {
        this.amountLimit = amountLimit;
    }

    @Override
    public String toString() {
        return "ABI{" +
                "name='" + name + '\'' +
                ", args=" + args +
                ", amountLimit=" + amountLimit +
                '}';
    }
}
