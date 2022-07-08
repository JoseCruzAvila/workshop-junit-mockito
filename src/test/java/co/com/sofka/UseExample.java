package co.com.sofka;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.sofka.classes.Dependency;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UseExample {
    @Mock
    private Dependency dependency;

    @Before
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        dependency = mock(Dependency.class);
    }

    @Test
    public void testDependency() {
        when(dependency.getClassName()).thenReturn("hi there");

        assertEquals("hi there", dependency.getClassName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() {
        when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);

        dependency.getClassName();
    }

    @Test
    public void testAddTwo() {
        when(dependency.addTwo(1)).thenReturn(5);

        assertEquals(5, dependency.addTwo(1));
        assertEquals(0, dependency.addTwo(27));
    }

    @Test
    public void testAddTwoAny() {
        when(dependency.addTwo(anyInt())).thenReturn(0);

        assertEquals(0, dependency.addTwo(3));
        assertEquals(0, dependency.addTwo(80));
    }
}
