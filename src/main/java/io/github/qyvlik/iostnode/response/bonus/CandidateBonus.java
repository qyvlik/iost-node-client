package io.github.qyvlik.iostnode.response.bonus;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class CandidateBonus {
    @JSONField(name = "bonus")
    private BigDecimal bonus;       // 可领取的投票收益

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "CandidateBonus{" +
                "bonus=" + bonus +
                '}';
    }
}
