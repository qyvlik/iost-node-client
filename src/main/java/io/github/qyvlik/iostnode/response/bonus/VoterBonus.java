package io.github.qyvlik.iostnode.response.bonus;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Map;

public class VoterBonus {

    @JSONField(name = "bonus")
    private BigDecimal bonus;                   // 可领取的总投票收益

    @JSONField(name = "detail")
    private Map<String, BigDecimal> detail;     // 从每个候选人得到的收益

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public Map<String, BigDecimal> getDetail() {
        return detail;
    }

    public void setDetail(Map<String, BigDecimal> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "VoterBonus{" +
                "bonus=" + bonus +
                ", detail=" + detail +
                '}';
    }
}
