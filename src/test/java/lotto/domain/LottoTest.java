package lotto.domain;

import lotto.domain.generator.AutoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.generator.LottoNumberGenerator.manualGenerate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    @DisplayName("램덤 번호로 로또 생성")
    @Test
    void lottoByAutoGenerator() {
        AutoGenerator autoGenerator = () -> Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers = autoGenerator.autoGenerate();
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getLotto()).isEqualTo(numbers);
    }

    @DisplayName("당첨 번호와 일치하는 번호가 몇 개인지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6 = 6",
            "1, 2, 3, 4, 5, 45 = 5",
            "1, 2, 3, 4, 44, 45 = 4",
            "1, 2, 3, 43, 44, 45 = 3"
    }, delimiter = '=')

    void countSameNumber(String numbers, int expectedCount) {
        Lotto winningLotto = new Lotto(manualGenerate("1, 2, 3, 4, 5, 6"));
        Lotto lotto = new Lotto(manualGenerate(numbers));
        int sameCount = lotto.countSameNumber(winningLotto);
        assertThat(sameCount).isEqualTo(expectedCount);
    }

}