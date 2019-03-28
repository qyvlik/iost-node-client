package io.github.qyvlik.iostnode;

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
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class IOSTNodeClientTest {


    RestTemplate restTemplate = new RestTemplate();
    String iostNodeHost = "http://13.52.105.102:30001";         // 测试链, testnet
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void getRestTemplate() throws Exception {
    }

    @Test
    public void setRestTemplate() throws Exception {
    }

    @Test
    public void getIostNodeHost() throws Exception {
    }

    @Test
    public void setIostNodeHost() throws Exception {
    }


    @Test
    public void getNodeInfo() throws Exception {


        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        NodeInfo response = iostNodeClient.getNodeInfo();

        logger.info("getNodeInfo response:{}", response);
    }

    @Test
    public void getChainInfo() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        ChainInfo response = iostNodeClient.getChainInfo();

        logger.info("getChainInfo response:{}", response);
    }

    @Test
    public void getGasRatio() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        GasRatio response = iostNodeClient.getGasRatio();

        logger.info("getGasRatio response:{}", response);
    }

    @Test
    public void getRAMInfo() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        RAMInfo response = iostNodeClient.getRAMInfo();

        logger.info("getRAMInfo response:{}", response);
    }

    @Test
    public void getTxByHash() throws Exception {

        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        String hash = "3P5QBwYyS9vRGQ63rvvTgUKMsEu3a7TDJ87bqNbZCjFU";

        Tx response = iostNodeClient.getTxByHash(hash);

        logger.info("getTxByHash hash:{} response:{}", hash, response);
    }

    @Test
    public void getTxReceiptByTxHash() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        String hash = "3P5QBwYyS9vRGQ63rvvTgUKMsEu3a7TDJ87bqNbZCjFU";

        TxReceipt response = iostNodeClient.getTxReceiptByTxHash(hash);

        logger.info("getTxReceiptByTxHash hash:{} response:{}", hash, response);
    }

    @Test
    public void getBlockByHash() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        String blockHash = "F1JLLg7BxBuPjsEiBwh5pN3JkgrNaHa776utpdgpFPSt";
        boolean complete = true;

        Block response = iostNodeClient.getBlockByHash(blockHash, complete);

        logger.info("getBlockByHash blockHash:{} complete:{} response:{}", blockHash, complete, response);
    }

    @Test
    public void getBlockByHash1() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        String blockHash = "F1JLLg7BxBuPjsEiBwh5pN3JkgrNaHa776utpdgpFPSt";
        boolean complete = false;

        Block response = iostNodeClient.getBlockByHash(blockHash, complete);

        logger.info("getBlockByHash1 blockHash:{} complete:{} response:{}", blockHash, complete, response);
    }

    @Test
    public void getBlockByNumber() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        Long blockNum = 3L;
        boolean complete = false;

        Block response = iostNodeClient.getBlockByNumber(blockNum, complete);

        logger.info("getBlockByNumber blockNum:{} complete:{} response:{}", blockNum, complete, response);
    }

    @Test
    public void getAccount() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        String account = "admin";
        boolean byLongestChain = true;

        Account response = iostNodeClient.getAccount(account, byLongestChain);

        logger.info("getAccount account:{} byLongestChain:{} response:{}", account, byLongestChain, response);
    }

    @Test
    public void getTokenBalance() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        String account = "admin";
        String token = "iost";
        boolean byLongestChain = true;

        TokenBalance response = iostNodeClient.getTokenBalance(account, token, byLongestChain);

        logger.info("getTokenBalance account:{} token:{} byLongestChain:{} response:{}",
                account, token, byLongestChain, response);
    }

    @Test
    public void getContract() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        String id = "token.iost";
        boolean byLongestChain = true;

        Contract response = iostNodeClient.getContract(id, byLongestChain);
        logger.info("getContract id:{} byLongestChain:{} response:{}",
                id, byLongestChain, response);
    }

    @Test
    public void getContractStorage() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        GetContractStorageRequest request = new GetContractStorageRequest();

        request.setId("token.iost");
        request.setKey("TBadmin");     // 'TB' + iost user account
        request.setField("iost");       // token name
        request.setByLongestChain(false);

        ContractStorage response = iostNodeClient.getContractStorage(request);

        logger.info("getContractStorage request:{}, response:{}",
                request, response);
    }

    @Test
    public void getContractStorageFields() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        GetContractStorageFieldsRequest request = new GetContractStorageFieldsRequest();

        request.setId("token.iost");
        request.setKey("TIiost");
        request.setByLongestChain(false);

        ContractStorageFields response = iostNodeClient.getContractStorageFields(request);

        logger.info("getContractStorageFields request:{}, response:{}",
                request, response);
    }

    @Test
    public void getCandidateBonus() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        String account = "admin";
        boolean byLongestChain = true;

        CandidateBonus response = iostNodeClient.getCandidateBonus(account, byLongestChain);

        logger.info("getCandidateBonus account:{} byLongestChain:{} response:{}", account, byLongestChain, response);
    }

    @Test
    public void getVoterBonus() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        String account = "admin";
        boolean byLongestChain = true;

        VoterBonus response = iostNodeClient.getVoterBonus(account, byLongestChain);

        logger.info("getVoterBonus account:{} byLongestChain:{} response:{}", account, byLongestChain, response);
    }

    @Test
    public void getTokenInfo() throws Exception {
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);

        String token = "iost";
        boolean byLongestChain = true;

        TokenInfo response = iostNodeClient.getTokenInfo(token, byLongestChain);

        logger.info("getTokenInfo token:{} byLongestChain:{} response:{}", token, byLongestChain, response);
    }
}