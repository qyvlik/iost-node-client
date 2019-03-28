package io.github.qyvlik.iostnode.response.info;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class GasRatio {
    /**
     * 最新的 block 中的打包成功的所有合约的最低 gas ratio
     */
    @JSONField(name = "lowest_gas_ratio")
    private BigDecimal lowestGasRatio;

    /**
     * 最新的 block 中的打包成功的所有合约的中位数 gas ratio
     */
    @JSONField(name = "median_gas_ratio")
    private BigDecimal medianGasRatio;

    public BigDecimal getLowestGasRatio() {
        return lowestGasRatio;
    }

    public void setLowestGasRatio(BigDecimal lowestGasRatio) {
        this.lowestGasRatio = lowestGasRatio;
    }

    public BigDecimal getMedianGasRatio() {
        return medianGasRatio;
    }

    public void setMedianGasRatio(BigDecimal medianGasRatio) {
        this.medianGasRatio = medianGasRatio;
    }

    @Override
    public String toString() {
        return "GasRatio{" +
                "lowestGasRatio=" + lowestGasRatio +
                ", medianGasRatio=" + medianGasRatio +
                '}';
    }
}
