package io.github.qyvlik.iostnode.response.tx;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;
import java.util.Map;

public class TxReceipt {

    public static final String TX_RECEIPT_STATUS_CODE_SUCCESS = "SUCCESS";                              // 成功
    public static final String TX_RECEIPT_STATUS_CODE_GAS_RUN_OUT = "GAS_RUN_OUT";                      //  Gas不足
    public static final String TX_RECEIPT_STATUS_CODE_BALANCE_NOT_ENOUGH = "BALANCE_NOT_ENOUGH";        // 余额不足
    public static final String TX_RECEIPT_STATUS_CODE_WRONG_PARAMETER = "WRONG_PARAMETER";              // 错误参数
    public static final String TX_RECEIPT_STATUS_CODE_RUNTIME_ERROR = "RUNTIME_ERROR";                  // 运行时错误
    public static final String TX_RECEIPT_STATUS_CODE_TIMEOUT = "TIMEOUT";                              // 超时
    public static final String TX_RECEIPT_STATUS_CODE_WRONG_TX_FORMAT = "WRONG_TX_FORMAT";              // 交易格式错误
    public static final String TX_RECEIPT_STATUS_CODE_WRONG_DUPLICATE_SET_CODE = "DUPLICATE_SET_CODE";  // 重复设置set code
    public static final String TX_RECEIPT_STATUS_CODE_WRONG_UNKNOWN_ERROR = "UNKNOWN_ERROR";            // 未知错误

    @JSONField(name = "tx_hash")
    private String txHash;                 // 交易的hash

    @JSONField(name = "gas_usage")
    private Double gasUsage;               // 交易执行的Gas消耗

    @JSONField(name = "ram_usage")
    private Map<String, Long> ramUsage;    // 交易的RAM消耗，map-key - 账户名，map-value - 使用RAM量

    @JSONField(name = "status_code")
    private String statusCode;             // 交易执行状态，SUCCESS - 成功，GAS_RUN_OUT - Gas不足，BALANCE_NOT_ENOUGH - 余额不足，WRONG_PARAMETER - 错误参数， RUNTIME_ERROR - 运行时错误， TIMEOUT - 超时， WRONG_TX_FORMAT - 交易格式错误， DUPLICATE_SET_CODE - 重复设置set code, UNKNOWN_ERROR - 未知错误

    @JSONField(name = "message")
    private String message;                // status_code的详细描述信息

    @JSONField(name = "returns")
    private List<String> returns;          // 每个Action的返回值

    @JSONField(name = "receipts")
    private List<Receipt> receipts;         // event功能使用


    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public Double getGasUsage() {
        return gasUsage;
    }

    public void setGasUsage(Double gasUsage) {
        this.gasUsage = gasUsage;
    }

    public Map<String, Long> getRamUsage() {
        return ramUsage;
    }

    public void setRamUsage(Map<String, Long> ramUsage) {
        this.ramUsage = ramUsage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getReturns() {
        return returns;
    }

    public void setReturns(List<String> returns) {
        this.returns = returns;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    @Override
    public String toString() {
        return "TxReceipt{" +
                "txHash='" + txHash + '\'' +
                ", gasUsage=" + gasUsage +
                ", ramUsage=" + ramUsage +
                ", statusCode='" + statusCode + '\'' +
                ", message='" + message + '\'' +
                ", returns=" + returns +
                ", receipts=" + receipts +
                '}';
    }
}
