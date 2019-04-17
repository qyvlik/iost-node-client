package io.github.qyvlik.iostnode.response.tx;

import com.alibaba.fastjson.annotation.JSONField;

public class Tx {
    public static final String TX_STATUS_PENDING = "PENDING";               // 交易在缓存中
    public static final String TX_STATUS_PACKED = "PACKED";                 // 交易在非不可逆块中
    public static final String TX_STATUS_IRREVERSIBLE = "IRREVERSIBLE";     // 交易在不可逆的块中

    @JSONField(name = "status")
    private String status;

    @JSONField(name = "transaction")
    private Transaction transaction;

    @JSONField(name = "block_number")
    private Long blockNumber;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Long getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(Long blockNumber) {
        this.blockNumber = blockNumber;
    }


    @Override
    public String toString() {
        return "Tx{" +
                "status='" + status + '\'' +
                ", transaction=" + transaction +
                ", blockNumber=" + blockNumber +
                '}';
    }
}
