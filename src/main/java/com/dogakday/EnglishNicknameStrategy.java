package com.dogakday;

import java.util.Random;

public class EnglishNicknameStrategy extends AbstractNicknameStrategy {

    public EnglishNicknameStrategy() {
        super("english_adjectives.txt", "english_nouns.txt");
    }

    @Override
    public String generateNickname(Integer adjectiveLength, Integer nounLength, Random random) {
        String adjective = generatePart(adjectives, adjectiveLength, random);
        String noun = generatePart(nouns, nounLength, random);
        return adjective + " " + noun;
    }
}
