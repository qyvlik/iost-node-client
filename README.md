# iost-node-client

iost-node-client

## maven

```xml
<dependency>
    <groupId>io.github.qyvlik</groupId>
    <artifactId>iost-node-client</artifactId>
    <version>1.0.1</version>
</dependency>
```

## deploy

```bash
export GPG_TTY=$(tty)
mvn clean deploy -Prelease -Dmaven.test.skip=true
```
