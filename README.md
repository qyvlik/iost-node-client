# iost-node-client

iost-node-client

## maven

```xml
<dependency>
    <groupId>io.github.qyvlik</groupId>
    <artifactId>iost-node-client</artifactId>
    <version>1.0.2</version>
</dependency>
```

## example

more examples in the `io.github.qyvlik.iostnode.IOSTNodeClientTest`

```java
class Tests {
    @Test
    public void test() {
        RestTemplate restTemplate = new RestTemplate();
        String iostNodeHost = "http://13.52.105.102:30001";         // 测试链, testnet
        IOSTNodeClient iostNodeClient = new IOSTNodeClient();
        iostNodeClient.setRestTemplate(restTemplate);
        iostNodeClient.setIostNodeHost(iostNodeHost);
        
        NodeInfo response = iostNodeClient.getNodeInfo();
    }
}
```

## deploy

```bash
export GPG_TTY=$(tty)
mvn clean deploy -Prelease -Dmaven.test.skip=true
```
