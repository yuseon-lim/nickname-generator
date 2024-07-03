# examples

```java
// korean
NicknameGenerator koreanGenerator = new NicknameGenerator.NicknameBuilder()
        .withLanguageMode("korean")
        .build();
String koreanNickname = koreanGenerator.generate();

// English
NicknameGenerator englishGenerator = new NicknameGenerator.NicknameBuilder()
        .withLanguageMode("english")
        .build();
String englishNickname = englishGenerator.generate();

// Korean with given length
NicknameGenerator koreanCustomGenerator = new NicknameGenerator.NicknameBuilder()
        .withLanguageMode("korean")
        .withAdjectiveLength(3)
        .withNounLength(3)
        .build();
String koreanCustomNickname = koreanCustomGenerator.generate();

// English with given length
NicknameGenerator englishCustomGenerator = new NicknameGenerator.NicknameBuilder()
        .withLanguageMode("english")
        .withAdjectiveLength(8)
        .withNounLength(7)
        .build();
String englishCustomNickname = englishCustomGenerator.generate();
```
