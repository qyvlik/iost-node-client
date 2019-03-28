package io.github.qyvlik.iostnode.response.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;

public class GasInfo {
    @JSONField(name = "current_total")
    private BigDecimal currentTotal;           // 当前Gas总量

    @JSONField(name = "transferable_gas")
    private BigDecimal transferableGas;        // 可以流通的Gas量

    @JSONField(name = "pledge_gas")
    private BigDecimal pledgeGas;              // 质押获得的Gas

    @JSONField(name = "increase_speed")
    private BigDecimal increaseSpeed;          // 每秒增加的Gas

    @JSONField(name = "limit")
    private BigDecimal limit;                   // 质押Token获得的Gas上限

    @JSONField(name = "pledged_info")
    private List<PledgeInfo> pledgedInfo;          // 本账号帮其他账号质押的信息

    public BigDecimal getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(BigDecimal currentTotal) {
        this.currentTotal = currentTotal;
    }

    public BigDecimal getTransferableGas() {
        return transferableGas;
    }

    public void setTransferableGas(BigDecimal transferableGas) {
        this.transferableGas = transferableGas;
    }

    public BigDecimal getPledgeGas() {
        return pledgeGas;
    }

    public void setPledgeGas(BigDecimal pledgeGas) {
        this.pledgeGas = pledgeGas;
    }

    public BigDecimal getIncreaseSpeed() {
        return increaseSpeed;
    }

    public void setIncreaseSpeed(BigDecimal increaseSpeed) {
        this.increaseSpeed = increaseSpeed;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public List<PledgeInfo> getPledgedInfo() {
        return pledgedInfo;
    }

    public void setPledgedInfo(List<PledgeInfo> pledgedInfo) {
        this.pledgedInfo = pledgedInfo;
    }

    @Override
    public String toString() {
        return "GasInfo{" +
                "currentTotal=" + currentTotal +
                ", transferableGas=" + transferableGas +
                ", pledgeGas=" + pledgeGas +
                ", increaseSpeed=" + increaseSpeed +
                ", limit=" + limit +
                ", pledgedInfo=" + pledgedInfo +
                '}';
    }
}
