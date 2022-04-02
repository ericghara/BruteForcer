# BruteForcer
BruteForcer is a CLI Utility and API to brute force byte sequencies.  The observed speeds are 10s of seconds to match a 4 byte sequence and around an hour for a 5 byte sequence.  This is of course highly system dependent, but is a reasonable frame of reference (after all brute forcing has an exponential time complexity).

## Build
```gradle clean build```
## Run
To brute force the byte sequence ```{13, 19, -126}```<br>
```java -jar build/libs/BruteForcer-0.0.1.jar 13 19 -126```

