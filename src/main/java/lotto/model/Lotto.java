package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    protected static final int MAX_LOTTO_NUMBER = 45;
    protected static final int MIN_LOTTO_NUMBER = 1;
    protected static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNotNullNumber(numbers);
        validateOutOfRangeNumber(numbers);
        validateDuplicatedNumber(numbers);
        validateLengthOfNumber(numbers);
    }

    private void validateNotNullNumber(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_NUMBER_SIZE + "개의 로또번호를 입력해주세요");
        }
    }

    private void validateLengthOfNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_NUMBER_SIZE + "개의 로또번호를 입력해주세요");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자를 가질 수 없습니다");
        }
    }

    private void validateOutOfRangeNumber(List<Integer> numbers) {
      if (numbers.stream()
                .anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER)) {
          throw new IllegalArgumentException("[ERROR] 로또 번호는 지정된 범위안의 숫자만 가질 수 있습니다 범위 "
                  + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER);
      }
    }

    protected boolean isInputNumberContainLottoNumbers(Integer inputNumber) {
        return (numbers.contains(inputNumber));
    }
}
