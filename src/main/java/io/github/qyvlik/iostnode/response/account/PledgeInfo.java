package io.github.qyvlik.iostnode.response.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class PledgeInfo {
    @JSONField(name = "pledger")
    private String pledger;             // 接受本账号质押的账号


    @JSONField(name = "amount")
    private BigDecimal amount;          // 本账号给 pledger 质押的金额

    public String getPledger() {
        return pledger;
    }

    public void setPledger(String pledger) {
        this.pledger = pledger;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PledgeInfo{" +
                "pledger='" + pledger + '\'' +
                ", amount=" + amount +
                '}';
    }
}
