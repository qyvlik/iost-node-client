package io.github.qyvlik.iostnode.response.tx;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;


public class Transaction {
    @JSONField(name = "hash")
    private String hash;                            // 交易的hash
    @JSONField(name = "time")
    private Long time;                              // 交易的时间戳
    @JSONField(name = "expiration")
    private Long expiration;                        // 交易的过期时间
    @JSONField(name = "gas_ratio")
    private Double gasRatio;                        // Gas费率，建议设置成1(1.00 ~ 100.00)，可以通过提高费率来让交易更容易被打包
    @JSONField(name = "gas_limit")
    private Double gasLimit;                        // Gas上限,执行交易所消耗的Gas不会超过这个上限
    @JSONField(name = "delay")
    private Long delay;                             // 延迟时间，交易会在延迟时间之后被执行，单位纳秒
    @JSONField(name = "chain_id")
    private Long chainId;                           // 网络 ID
    @JSONField(name = "actions")
    private List<Action> actions;               // 交易的最小执行单元
    @JSONField(name = "signers")
    private List<String> signers;                   // 交易的签名列表
    @JSONField(name = "publisher")
    private String publisher;                       // 交易提交者,承担交易的执行费用
    @JSONField(name = "referred_tx")
    private String referredTx;                      // 交易生成依赖，用于延迟交易
    @JSONField(name = "amount_limit")
    private List<AmountLimit> amountLimit;      // 用户可以设置的花费token的限制, 如 {"iost": 100} 即本次交易对于每个签名者花费iost不超过100
    @JSONField(name = "tx_receipt")
    private TxReceipt txReceipt;          // 交易Action的receipt

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public Double getGasRatio() {
        return gasRatio;
    }

    public void setGasRatio(Double gasRatio) {
        this.gasRatio = gasRatio;
    }

    public Double getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(Double gasLimit) {
        this.gasLimit = gasLimit;
    }

    public Long getDelay() {
        return delay;
    }

    public void setDelay(Long delay) {
        this.delay = delay;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<String> getSigners() {
        return signers;
    }

    public void setSigners(List<String> signers) {
        this.signers = signers;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReferredTx() {
        return referredTx;
    }

    public void setReferredTx(String referredTx) {
        this.referredTx = referredTx;
    }

    public List<AmountLimit> getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(List<AmountLimit> amountLimit) {
        this.amountLimit = amountLimit;
    }

    public TxReceipt getTxReceipt() {
        return txReceipt;
    }

    public void setTxReceipt(TxReceipt txReceipt) {
        this.txReceipt = txReceipt;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "hash='" + hash + '\'' +
                ", time=" + time +
                ", expiration=" + expiration +
                ", gasRatio=" + gasRatio +
                ", gasLimit=" + gasLimit +
                ", delay=" + delay +
                ", chainId=" + chainId +
                ", actions=" + actions +
                ", signers=" + signers +
                ", publisher='" + publisher + '\'' +
                ", referredTx='" + referredTx + '\'' +
                ", amountLimit=" + amountLimit +
                ", txReceipt=" + txReceipt +
                '}';
    }
}
