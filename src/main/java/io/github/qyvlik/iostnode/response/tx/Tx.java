package io.github.qyvlik.iostnode.response.tx;

import com.alibaba.fastjson.annotation.JSONField;

public class Tx {
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
