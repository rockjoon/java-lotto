package lotto.domain;

import lotto.domain.generator.AutoGeneratable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    @DisplayName("램덤 번호로 로또 생성")
    @Test
    void lottoByAutoGenerator() {
        AutoGeneratable autoGenerator = () -> Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers = autoGenerator.autoGenerate();
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getLotto()).isEqualTo(numbers);
    }

}