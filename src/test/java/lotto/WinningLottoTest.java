package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {
    @DisplayName("보너스 번호에 범위(1 ~ 45) 밖의 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createWinningLottoByBonusNumberOverRange(Integer bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또번호에 포함되어져있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByLottoNumbersContainBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 null인 경우 예외가 발생한다..")
    @ParameterizedTest
    @NullSource
    void createWinningLottoByNullOrEmptyBonusNumber(Integer bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
