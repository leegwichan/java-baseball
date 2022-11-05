package baseball.question;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

import baseball.answer.BaseballAnswer;
import baseball.gametype.BaseballType;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

public class BaseballQuestionTest {

    @Test
    void askTest_ifFormatIsNotCorrect(){
        try (MockedConstruction<BaseballAnswer> mockBaseballAnswer = mockConstruction(BaseballAnswer.class)) {

            BaseballType mockBaseballType = mock(BaseballType.class);
            when(mockBaseballType.isFormatCorrect()).thenReturn(false);

            assertThrows(IllegalArgumentException.class, () -> {
               new BaseballQuestion(mockBaseballType).ask(123);
            });
        }
    }
}
