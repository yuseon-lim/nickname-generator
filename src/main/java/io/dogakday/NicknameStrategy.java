package io.dogakday;

import java.util.Random;

public interface NicknameStrategy {
    String generateNickname(Integer adjectiveLength, Integer nounLength, Random random);
}
