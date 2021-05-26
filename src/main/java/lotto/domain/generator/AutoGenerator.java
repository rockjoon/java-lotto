package lotto.domain.generator;

import java.util.List;

@FunctionalInterface
public interface AutoGenerator {

    List<Integer> autoGenerate();

}
