package nl.belastingdienst.tdd.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TargetTest {

    @Mock
    private Dependency dMock;

    @InjectMocks
    private Target target;

    @Test
    void methode() {
        // given

        // when
        when(dMock.x()).thenReturn(10);
        int methodeResultaat = target.methode();

        // then
        assertThat(methodeResultaat).isEqualTo(40);
        verify(dMock, times(2)).x();
    }

}
