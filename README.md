# Anagrams

Small utility to find anagrams of an input.

```
mvn clean install
```

There are two implementations. Both will be built as runnable jars by the command above.

```
java -jar ./target/first-anagrams.jar-jar-with-dependencies.jar dictionary.txt
```

Or:

```
java -jar ./target/second-anagrams.jar-jar-with-dependencies.jar dictionary.txt
```

The first implementation is a simple "brute force" implementation. The second implementation utilizes a bloom filter.