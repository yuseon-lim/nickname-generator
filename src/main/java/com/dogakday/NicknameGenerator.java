package com.dogakday;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NicknameGenerator {
    private static final Set<String> GENERATED_NAMES = new HashSet<>();
    private static final Random RANDOM = new Random();

    private Integer adjectiveLength;
    private Integer nounLength;
    private NicknameStrategy strategy;

    public NicknameGenerator(Integer adjectiveLength, Integer nounLength, NicknameStrategy strategy) {
        this.adjectiveLength = adjectiveLength;
        this.nounLength = nounLength;
        this.strategy = strategy;
    }

    public String generate() {
        String nickname = strategy.generateNickname(adjectiveLength, nounLength, RANDOM);

        while (GENERATED_NAMES.contains(nickname)) {
            nickname = strategy.generateNickname(adjectiveLength, nounLength, RANDOM);
        }

        GENERATED_NAMES.add(nickname);
        return nickname;
    }

    public static class NicknameBuilder {
        private Integer adjectiveLength = null;
        private Integer nounLength = null;
        private NicknameStrategy strategy;

        public NicknameBuilder withAdjectiveLength(int length) {
            this.adjectiveLength = length;
            return this;
        }

        public NicknameBuilder withNounLength(int length) {
            this.nounLength = length;
            return this;
        }

        public NicknameBuilder withLanguageMode(String chosenLanguageMode) {
            this.strategy = getStrategy(chosenLanguageMode);
            return this;
        }

        public NicknameGenerator build() {
            if (strategy == null) {
                throw new IllegalStateException(
                        "Language mode must be set. Use withLanguageMode() method. Supported language modes: KOREAN, ENGLISH");
            }
            return new NicknameGenerator(adjectiveLength, nounLength, strategy);
        }

        protected NicknameStrategy getStrategy(String chosenLanguageMode) {
            LanguageMode mode = LanguageMode.valueOf(chosenLanguageMode.toUpperCase());
            switch (mode) {
                case KOREAN:
                    return new KoreanNicknameStrategy();
                case ENGLISH:
                    return new EnglishNicknameStrategy();
                default:
                    throw new IllegalArgumentException(
                            "Unsupported language mode. Supported language modes: KOREAN, ENGLISH");
            }
        }
    }

    public enum LanguageMode {
        KOREAN, ENGLISH
    }
}
