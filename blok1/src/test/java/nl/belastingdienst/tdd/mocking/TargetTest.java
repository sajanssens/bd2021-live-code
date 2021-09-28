package nl.belastingdienst.tdd.mocking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class TargetTest {

    private Target target = new Target();
    private Dependency dMock = mock(Dependency.class);

    @Test
    void methode() {
        // given
        target.setD(dMock);

        // when
        when(dMock.x()).thenReturn(10);
        int methodeResultaat = target.methode();

        // then
        assertThat(methodeResultaat).isEqualTo(40);
        verify(dMock, times(2)).x();
    }

}
