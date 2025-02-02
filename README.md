# Nickname Generator

`nickname-generator` is a simple and easy-to-use library for generating fun and unique nicknames. Nickname generator composed of adjective + noun.

## Features
- Random nickname generation
- Two language modes (Korean, English)
- Ability to limit the length of adjectives and nouns

## Installation

> Java 11 or higher is required to use this library.

You can install it using Maven:

```xml
<dependency>
    <groupId>io.github.dogakday</groupId>
    <artifactId>nickname-generator</artifactId>
    <version>0.1.1</version>
</dependency>
```

You can also install it using Gradle:

```groovy
// gradle
implementation group: 'io.github.dogakday', name: 'nickname-generator', version: '0.1.1'

// gradle (short)
implementation 'io.github.dogakday:nickname-generator:0.1.1'

// gradle (kotlin)
implementation("io.github.dogakday:nickname-generator:0.1.1")
```

## Usage

### Basic Usage

```java
// korean
NicknameGenerator koreanGenerator = new NicknameGenerator.NicknameBuilder()
        .withLanguageMode("korean")
        .build();

System.out.println(koreanGenerator.generate());

// english
NicknameGenerator englishGenerator = new NicknameGenerator.NicknameBuilder()
        .withLanguageMode("english")
        .build();

System.out.println(englishGenerator.generate());
```

### Customizing Options

You can customize the nickname generation by setting various options:

```java
NicknameGenerator customGenerator = new NicknameGenerator.NicknameBuilder()
        .withLanguageMode("korean")
        .withAdjectiveLength(4)
        .withNounLength(3)
        .build();

System.out.println(customGenerator.generate());
```

## ⭐️ Note

The words used in this library were manually filtered by me, but there might still be some mistakes. If you encounter any offensive words, please report them immediately via an issue, and I will address them promptly.

## 💌 Contributing

We welcome contributions! If you find any issues or have suggestions, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](https://github.com/dogakday/nickname-generator/blob/main/LICENSE) file for details.

## Credits

The words used in this library were sourced and filtered manually. Here are the references for the word lists used:

- Korean
  - [위키낱말사전](https://ko.wiktionary.org/wiki)
- English
  - Adjectives
    - [gist by hugsy](https://gist.github.com/hugsy/8910dc78d208e40de42deb29e62df913)
  - Nouns:
    - [gist by atduskgreg](https://gist.github.com/atduskgreg/3cf8ef48cb0d29cf151bedad81553a54)
    - [gist by wsc](https://gist.github.com/wsc/1083459)
