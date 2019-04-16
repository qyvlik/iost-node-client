package io.github.qyvlik.iostnode;

import com.alibaba.fastjson.JSON;
import io.github.qyvlik.iostnode.request.GetContractStorageFieldsRequest;
import io.github.qyvlik.iostnode.request.GetContractStorageRequest;
import io.github.qyvlik.iostnode.response.account.Account;
import io.github.qyvlik.iostnode.response.account.TokenBalance;
import io.github.qyvlik.iostnode.response.block.Block;
import io.github.qyvlik.iostnode.response.bonus.CandidateBonus;
import io.github.qyvlik.iostnode.response.bonus.VoterBonus;
import io.github.qyvlik.iostnode.response.contract.Contract;
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

    private String getFullUrl(String path) {
        return iostNodeHost.endsWith("/") ? iostNodeHost + path : iostNodeHost + "/" + path;
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

        String url = getFullUrl("getNodeInfo");

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

        String url = getFullUrl("getChainInfo");

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
        String url = getFullUrl("getGasRatio");

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
    public RAMInfoDetail getRAMInfo() {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getRAMInfo failure : iostNodeHost is empty");
        }
        if (restTemplate == null) {
            throw new RuntimeException("getRAMInfo failure : restTemplate is null");
        }
        String url = getFullUrl("getRAMInfo");

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(RAMInfoDetail.class);
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

        String url = getFullUrl("getTxByHash/" + hash);

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

        String url = getFullUrl("getTxReceiptByTxHash/" + hash);

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

        String url = getFullUrl("getBlockByHash/" + blockHash + "/" + complete);

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

        String url = getFullUrl("getBlockByNumber/" + blockNum + "/" + complete);

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

        String url = getFullUrl("getAccount/" + account + "/" + byLongestChain);

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

        String url = getFullUrl("getTokenBalance/" + account + "/" + token + "/" + byLongestChain);

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(TokenBalance.class);
        } catch (Exception e) {
            logger.error("getTokenBalance {} failure :{} ", account, e.getMessage());
        }
        return null;
    }

    /**
     * 通过合约ID获取合约数据
     *
     * @param id             合约的ID
     * @param byLongestChain true - 从最长链得到数据，false - 从不可逆块得到数据
     * @return Contract
     */
    public Contract getContract(String id, boolean byLongestChain) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getContract failure : iostNodeHost is empty, id:" + id);
        }
        if (restTemplate == null) {
            throw new RuntimeException("getContract failure : restTemplate is null, id:" + id);
        }
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException("getContract failure : id is empty");
        }
        String url = getFullUrl("getContract/" + id + "/" + byLongestChain);

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(Contract.class);
        } catch (Exception e) {
            logger.error("getContract {} failure :{} ", id, e.getMessage());
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

        String url = getFullUrl("getContractStorage");

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

        String url = getFullUrl("getContractStorageFields");

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
     * 获取节点可领取的投票收益
     *
     * @param name           节点账户名
     * @param byLongestChain true - 从最长链得到数据，false - 从不可逆块得到数据
     * @return CandidateBonus
     */
    public CandidateBonus getCandidateBonus(String name, boolean byLongestChain) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getCandidateBonus failure : iostNodeHost is empty, name:" + name);
        }
        if (restTemplate == null) {
            throw new RuntimeException("getCandidateBonus failure : restTemplate is null, name:" + name);
        }
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("getCandidateBonus failure : name is empty");
        }

        String url = getFullUrl("getCandidateBonus/" + name + "/" + byLongestChain);

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(CandidateBonus.class);
        } catch (Exception e) {
            logger.error("getCandidateBonus {} failure :{} ", name, e.getMessage());
        }
        return null;
    }

    /**
     * 获取投票者可领取的投票收益
     *
     * @param name           投票者账户名
     * @param byLongestChain true - 从最长链得到数据，false - 从不可逆块得到数据
     * @return VoterBonus
     */
    public VoterBonus getVoterBonus(String name, boolean byLongestChain) {
        if (StringUtils.isBlank(iostNodeHost)) {
            throw new RuntimeException("getVoterBonus failure : iostNodeHost is empty, name:" + name);
        }
        if (restTemplate == null) {
            throw new RuntimeException("getVoterBonus failure : restTemplate is null, name:" + name);
        }
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("getVoterBonus failure : name is empty");
        }

        String url = getFullUrl("getVoterBonus/" + name + "/" + byLongestChain);

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(VoterBonus.class);
        } catch (Exception e) {
            logger.error("getVoterBonus {} failure :{} ", name, e.getMessage());
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

        String url = getFullUrl("getTokenInfo/" + token + "/" + byLongestChain);

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return JSON.parseObject(response.getBody()).toJavaObject(TokenInfo.class);
        } catch (Exception e) {
            logger.error("getTokenInfo {} failure :{} ", token, e.getMessage());
        }
        return null;
    }
}
