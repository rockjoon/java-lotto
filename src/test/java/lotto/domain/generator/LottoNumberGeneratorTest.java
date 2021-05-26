package lotto.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.domain.generator.LottoNumberGenerator.LOTTO_NUMBER_POOL;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호 수동 생성 확인")
    @Test
    void manualGenerate() {
        String input = "1, 2, 3, 4, 5, 6";
        ManualGeneratable manualGenerator = new LottoNumberGenerator();
        List<Integer> numbers = manualGenerator.manualGenerate(input);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("수동으로 입력한 값이 1~45 사이의 값이 아닐 경우 IllegalArgumentException 발생 확인")
    @Test
    void isInLottoNumberPool() {
        String input = "46, 47, 48, 49, 50, 51";
        ManualGeneratable manualGenerator = new LottoNumberGenerator();
        assertThatThrownBy(() -> manualGenerator.manualGenerate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}