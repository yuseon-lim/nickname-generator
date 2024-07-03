package com.dogakday;

import java.util.Random;

public class KoreanNicknameStrategy extends AbstractNicknameStrategy {

    public KoreanNicknameStrategy() {
        super("korean_adjectives.txt", "korean_nouns.txt");
    }

    @Override
    public String generateNickname(Integer adjectiveLength, Integer nounLength, Random random) {
        String adjective = generatePart(adjectives, adjectiveLength, random);
        String noun = generatePart(nouns, nounLength, random);
        return adjective + " " + noun;
    }
}
