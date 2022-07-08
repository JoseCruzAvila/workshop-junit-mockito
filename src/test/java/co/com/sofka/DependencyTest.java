package co.com.sofka;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import co.com.sofka.classes.Dependency;
import co.com.sofka.classes.SubDependency;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DependencyTest {
    @Mock
    private SubDependency subDependency;
    private Dependency dependency;

    @Before
    public void setupMock() {
        subDependency = mock(SubDependency.class);
        dependency = new Dependency(subDependency);
    }

    @Test
    public void testSubDependency() {
        when(subDependency.getClassName()).thenReturn("hi there 2");

        assertEquals("hi there 2", dependency.getSubdepedencyClassName());
    }
}
