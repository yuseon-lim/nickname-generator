package com.dogakday;

import java.util.List;
import java.util.Random;

public abstract class AbstractNicknameStrategy implements NicknameStrategy {
    protected List<String> adjectives;
    protected List<String> nouns;

    public AbstractNicknameStrategy(String adjectiveFileName, String nounFileName) {
        this.adjectives = FileUtil.readWordsFromFile(adjectiveFileName);
        this.nouns = FileUtil.readWordsFromFile(nounFileName);
    }

    protected String generatePart(List<String> parts, Integer length, Random random) {
        List<String> filteredParts = (length != null) ? FileUtil.filterWordsByLength(parts, length) : parts;
        if (filteredParts.isEmpty()) {
            throw new IllegalArgumentException("No words found with the specified length");
        }
        return filteredParts.get(random.nextInt(filteredParts.size()));
    }
}
