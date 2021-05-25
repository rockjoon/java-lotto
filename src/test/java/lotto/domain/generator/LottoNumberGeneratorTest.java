package lotto.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.domain.generator.LottoNumberGenerator.LOTTO_NUMBER_POOL;

class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 자동 생성 확인")
    @Test
    void autoGenerate() {
        LottoNumberGenerator autoGenerator = new LottoNumberGenerator();
        List<Integer> numbers = autoGenerator.autoGenerate();
        assertThat(numbers).hasSize(6);
        for (int n : numbers) {
            assertThat(n).isIn(LOTTO_NUMBER_POOL);
        }
    }

}