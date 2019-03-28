package io.github.qyvlik.iostnode.response.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class FrozenBalance {
    @JSONField(name = "amount")
    private BigDecimal amount;      // 金额

    @JSONField(name = "time")
    private Long time;              // 解冻时间

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FrozenBalance{" +
                "amount=" + amount +
                ", time=" + time +
                '}';
    }
}
