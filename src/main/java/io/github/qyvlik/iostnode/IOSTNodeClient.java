package io.github.qyvlik.iostnode;

import com.alibaba.fastjson.JSON;
import io.github.qyvlik.iostnode.request.GetContractStorageFieldsRequest;
import io.github.qyvlik.iostnode.request.GetContractStorageRequest;
import io.github.qyvlik.iostnode.response.account.Account;
import io.github.qyvlik.iostnode.response.account.TokenBalance;
import io.github.qyvlik.iostnode.response.block.Block;
import io.github.qyvlik.iostnode.response.info.*;
import io.github.qyvlik.iostnode.response.storage.ContractStorage;
import io.github.qyvlik.iostnode.response.storage.ContractStorageFields;
import io.github.qyvlik.iostnode.response.tx.Tx;
import io.github.qyvlik.iostnode.response.tx.TxReceipt;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

// https://developers.iost.io/docs/zh-CN/6-reference/API.html
public class IOSTNodeClient {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private RestTemplate restTemplate;
    private String iostNodeHost;

    public IOSTNodeClient() {

    }

    public IOSTNodeClient(RestTemplate restTemplate, String iostNodeHost) {
        this.restTemplate = restTemplate;
        this.iostNodeHost = iostNodeHost;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getIostNodeHost() {
        return iostNodeHost;
    }

    public void setIostNodeHost(String iostNodeHost) {
        this.iostNodeHost = iostNodeHost;
    }

    /**
     * 获得节点的信息
     *
     * @return NodeInfo
     */
    public NodeInfo getNodeInfo() {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getNodeInfo failure : iostNodeHost is empty");
        }
        if (restTemplate == null) {
            throw new RuntimeException("getNodeInfo failure : restTemplate is null");
        }

        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getNodeInfo";
        } else {
            url = iostNodeHost + "/getNodeInfo";
        }

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(NodeInfo.class);
        } catch (Exception e) {
            logger.error("getNodeInfo failure :{} ", e.getMessage());
        }
        return null;
    }

    /**
     * 获得区块链的信息
     *
     * @return ChainInfo
     */
    public ChainInfo getChainInfo() {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getChainInfo failure : iostNodeHost is empty");
        }
        if (restTemplate == null) {
            throw new RuntimeException("getChainInfo failure : restTemplate is null");
        }

        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getChainInfo";
        } else {
            url = iostNodeHost + "/getChainInfo";
        }

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(ChainInfo.class);
        } catch (Exception e) {
            logger.error("getChainInfo failure :{} ", e.getMessage());
        }
        return null;
    }

    /**
     * 获取当前上链交易的 gas 倍率信息，方便用户合理设置自己交易的 gas 倍率。
     * 建议使用比 lowest_gas_ratio 稍高的 gas ratio 值，来保证交易尽快上链。
     *
     * @return GasRatio
     */
    public GasRatio getGasRatio() {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getGasRatio failure : iostNodeHost is empty");
        }
        if (restTemplate == null) {
            throw new RuntimeException("getGasRatio failure : restTemplate is null");
        }
        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getGasRatio";
        } else {
            url = iostNodeHost + "/getGasRatio";
        }

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(GasRatio.class);
        } catch (Exception e) {
            logger.error("getGasRatio failure :{} ", e.getMessage());
        }
        return null;
    }

    /**
     * 获取当前区块链的RAM信息，包括用量和价格。
     *
     * @return RAMInfo
     */
    public RAMInfo getRAMInfo() {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getRAMInfo failure : iostNodeHost is empty");
        }
        if (restTemplate == null) {
            throw new RuntimeException("getRAMInfo failure : restTemplate is null");
        }
        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getRAMInfo";
        } else {
            url = iostNodeHost + "/getRAMInfo";
        }

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(RAMInfo.class);
        } catch (Exception e) {
            logger.error("getRAMInfo failure :{} ", e.getMessage());
        }
        return null;
    }

    /**
     * 通过交易hash获取交易数据
     *
     * @param hash 交易 hash
     * @return Tx
     */
    public Tx getTxByHash(String hash) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getTxByHash failure : iostNodeHost is empty, hash:" + hash);
        }
        if (restTemplate == null) {
            throw new RuntimeException("getTxByHash failure : restTemplate is null, hash:" + hash);
        }
        if (StringUtils.isBlank(hash)) {
            throw new RuntimeException("getTxByHash failure : hash is empty");
        }

        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getTxByHash/" + hash;
        } else {
            url = iostNodeHost + "/getTxByHash/" + hash;
        }

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(Tx.class);
        } catch (Exception e) {
            logger.error("getTxByHash {} failure :{} ", hash, e.getMessage());
        }
        return null;
    }

    /**
     * 通过交易hash获取交易receipt数据
     *
     * @param hash receipt的hash
     * @return TxReceipt
     */
    public TxReceipt getTxReceiptByTxHash(String hash) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getTxReceiptByTxHash failure : iostNodeHost is empty, hash:" + hash);
        }
        if (restTemplate == null) {
            throw new RuntimeException("getTxReceiptByTxHash failure : restTemplate is null, hash:" + hash);
        }
        if (StringUtils.isBlank(hash)) {
            throw new RuntimeException("getTxReceiptByTxHash failure : hash is empty");
        }

        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getTxReceiptByTxHash/" + hash;
        } else {
            url = iostNodeHost + "/getTxReceiptByTxHash/" + hash;
        }

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(TxReceipt.class);
        } catch (Exception e) {
            logger.error("getTxReceiptByTxHash {} failure :{} ", hash, e.getMessage());
        }
        return null;
    }

    /**
     * 通过block hash获取block的数据
     *
     * @param blockHash block hash
     * @param complete  true - 显示block中的交易， false - 不显示block中交易详情
     * @return Block
     */
    public Block getBlockByHash(String blockHash, boolean complete) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getBlockByHash failure : iostNodeHost is empty, blockHash:" + blockHash);
        }
        if (restTemplate == null) {
            throw new RuntimeException("getBlockByHash failure : restTemplate is null, blockHash:" + blockHash);
        }
        if (StringUtils.isBlank(blockHash)) {
            throw new RuntimeException("getBlockByHash failure : blockHash is empty");
        }

        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getBlockByHash/" + blockHash + "/" + complete;
        } else {
            url = iostNodeHost + "/getBlockByHash/" + blockHash + "/" + complete;
        }

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(Block.class);
        } catch (Exception e) {
            logger.error("getBlockByHash {} failure :{} ", blockHash, e.getMessage());
        }
        return null;
    }

    /**
     * 通过block号获取block的数据
     *
     * @param blockNum block号
     * @param complete true - 显示block中的交易， false - 不显示block中交易详情
     * @return Block
     */
    public Block getBlockByNumber(Long blockNum, boolean complete) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getBlockByNumber failure : iostNodeHost is empty, blockNum:" + blockNum);
        }
        if (restTemplate == null) {
            throw new RuntimeException("getBlockByNumber failure : restTemplate is null, blockNum:" + blockNum);
        }
        if (blockNum == null || blockNum < 0) {
            throw new RuntimeException("getBlockByNumber failure : blockNum must bigger than zero");
        }

        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getBlockByNumber/" + blockNum + "/" + complete;
        } else {
            url = iostNodeHost + "/getBlockByNumber/" + blockNum + "/" + complete;
        }

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(Block.class);
        } catch (Exception e) {
            logger.error("getBlockByNumber {} failure :{} ", blockNum, e.getMessage());
        }
        return null;
    }

    /**
     * @param account        账户名
     * @param byLongestChain true - 从最长链得到数据，false - 从不可逆块得到数据
     * @return Account
     */
    public Account getAccount(String account, boolean byLongestChain) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getAccount failure : iostNodeHost is empty, account:" + account);
        }
        if (restTemplate == null) {
            throw new RuntimeException("getAccount failure : restTemplate is null, account:" + account);
        }
        if (StringUtils.isBlank(account)) {
            throw new RuntimeException("getAccount failure : account is empty");
        }

        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getAccount/" + account + "/" + byLongestChain;
        } else {
            url = iostNodeHost + "/getAccount/" + account + "/" + byLongestChain;
        }

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(Account.class);
        } catch (Exception e) {
            logger.error("getAccount {} failure :{} ", account, e.getMessage());
        }
        return null;
    }

    /**
     * 获取账号指定代币的余额
     *
     * @param account        账号名
     * @param token          代币名字
     * @param byLongestChain true - 从最长链得到数据，false - 从不可逆块得到数据
     * @return TokenBalance
     */
    public TokenBalance getTokenBalance(String account, String token, boolean byLongestChain) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getTokenBalance failure : iostNodeHost is empty, account:" + account);
        }
        if (restTemplate == null) {
            throw new RuntimeException("getTokenBalance failure : restTemplate is null, account:" + account);
        }
        if (StringUtils.isBlank(account)) {
            throw new RuntimeException("getTokenBalance failure : account is empty");
        }
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException("getTokenBalance failure : token is empty");
        }

        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getTokenBalance/" + account + "/" + token + "/" + byLongestChain;
        } else {
            url = iostNodeHost + "/getTokenBalance/" + account + "/" + token + "/" + byLongestChain;
        }

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(TokenBalance.class);
        } catch (Exception e) {
            logger.error("getTokenBalance {} failure :{} ", account, e.getMessage());
        }
        return null;
    }

    /**
     * 本地获取合约的存储数据
     *
     * @param request GetContractStorageRequest
     * @return ContractStorage
     */
    public ContractStorage getContractStorage(GetContractStorageRequest request) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getContractStorage failure : iostNodeHost is empty");
        }
        if (restTemplate == null) {
            throw new RuntimeException("getContractStorage failure : restTemplate is null");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<String> entity = new HttpEntity<>(JSON.toJSONString(request), headers);

        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getContractStorage";
        } else {
            url = iostNodeHost + "/getContractStorage";
        }
        try {
            ResponseEntity<String> response
                    = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            return JSON.parseObject(response.getBody()).toJavaObject(ContractStorage.class);
        } catch (Exception e) {
            logger.error("getContractStorage failure :{} ", e.getMessage());
        }

        return null;
    }

    /**
     * 获取合约存储中 map 的 key 列表，最多返回 256 条。
     *
     * @param request 请求
     * @return ContractStorageFields
     */
    public ContractStorageFields getContractStorageFields(GetContractStorageFieldsRequest request) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getContractStorageFields failure : iostNodeHost is empty");
        }
        if (restTemplate == null) {
            throw new RuntimeException("getContractStorageFields failure : restTemplate is null");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<String> entity = new HttpEntity<>(JSON.toJSONString(request), headers);

        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getContractStorageFields";
        } else {
            url = iostNodeHost + "/getContractStorageFields";
        }
        try {
            ResponseEntity<String> response
                    = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            return JSON.parseObject(response.getBody()).toJavaObject(ContractStorageFields.class);
        } catch (Exception e) {
            logger.error("getContractStorageFields failure :{} ", e.getMessage());
        }

        return null;
    }

    /**
     * 获取 token 信息
     *
     * @param token          token 名字
     * @param byLongestChain true - 从最长链得到数据，false - 从不可逆块得到数据
     * @return TokenInfo
     */
    public TokenInfo getTokenInfo(String token, boolean byLongestChain) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getTokenInfo failure : iostNodeHost is empty, token:" + token);
        }
        if (restTemplate == null) {
            throw new RuntimeException("getTokenInfo failure : restTemplate is null, token:" + token);
        }
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException("getTokenInfo failure : token is empty");
        }

        String url = "";
        if (iostNodeHost.endsWith("/")) {
            url = iostNodeHost + "getTokenInfo/" + token + "/" + byLongestChain;
        } else {
            url = iostNodeHost + "/getTokenInfo/" + token + "/" + byLongestChain;
        }

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(TokenInfo.class);
        } catch (Exception e) {
            logger.error("getTokenInfo {} failure :{} ", token, e.getMessage());
        }
        return null;
    }
}
