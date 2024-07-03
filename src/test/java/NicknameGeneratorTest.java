import static org.assertj.core.api.Assertions.assertThat;

import com.dogakday.NicknameGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NicknameGeneratorTest {
    @Test
    @DisplayName("한국어 닉네임 생성 테스트")
    void testGenerateKoreanNickname() {
        // 한국어 모드로 닉네임 생성
        NicknameGenerator koreanGenerator = new NicknameGenerator.NicknameBuilder()
                .withLanguageMode("KOREAN")
                .build();
        String koreanNickname = koreanGenerator.generate();
        assertThat(koreanNickname).isNotNull();
    }

    @Test
    @DisplayName("영어 닉네임 생성 테스트")
    void testGenerateEnglishNickname() {
        // 영어 모드로 닉네임 생성
        NicknameGenerator englishGenerator = new NicknameGenerator.NicknameBuilder()
                .withLanguageMode("english")
                .build();
        String englishNickname = englishGenerator.generate();
        assertThat(englishNickname).isNotNull();
    }

    @Test
    @DisplayName("한국어 글자수 제한 닉네임 생성 테스트")
    void testGenerateKoreanNicknameWithCustomLength() {
        for (int i = 0; i < 10000; i++) {
            // 한국어 모드로 닉네임 생성 (관형사 길이 3, 명사 길이 3)
            NicknameGenerator koreanCustomGenerator = new NicknameGenerator.NicknameBuilder()
                    .withLanguageMode("korean")
                    .withAdjectiveLength(3)
                    .withNounLength(3)
                    .build();
            String koreanCustomNickname = koreanCustomGenerator.generate();
            String[] koreanCustomNicknameParts = koreanCustomNickname.split(" ");
            String koreanAdjective = koreanCustomNicknameParts[0];
            String koreanNoun = koreanCustomNicknameParts[1];
            assertThat(koreanAdjective.length()).isEqualTo(3);
            assertThat(koreanNoun.length()).isEqualTo(3);
        }
    }

    @Test
    @DisplayName("영어 글자수 제한 닉네임 생성 테스트")
    void testGenerateEnglishNicknameWithCustomLength() {
        for (int i = 0; i < 10000; i++) {
            // 영어 모드로 닉네임 생성 (관형사 길이 8, 명사 길이 7)
            NicknameGenerator englishCustomGenerator = new NicknameGenerator.NicknameBuilder()
                    .withLanguageMode("English")
                    .withAdjectiveLength(8)
                    .withNounLength(7)
                    .build();
            String englishCustomNickname = englishCustomGenerator.generate();
            int firstSpaceIndex = englishCustomNickname.indexOf(' ');
            String englishAdjective = englishCustomNickname.substring(0, firstSpaceIndex);
            String englishNoun = englishCustomNickname.substring(firstSpaceIndex + 1);
            assertThat(englishAdjective.length()).isEqualTo(8);
            assertThat(englishNoun.length()).isEqualTo(7);
        }
    }
}
