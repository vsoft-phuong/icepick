package icepick.bundle;

import android.os.Bundle;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.verify;

@PrepareForTest(Bundle.class)
@RunWith(PowerMockRunner.class)
public class FragmentActivityInjectorTest {

    final Bundle bundle = PowerMockito.mock(Bundle.class);
    final FragmentActivityInjector fragmentActivityInjector = new FragmentActivityInjector(new ClassToInject(), bundle, new HashMap<MethodKey, Method>());

    @Test
    public void shouldRestoreFieldValueWithBundleContent() throws Exception {
        fragmentActivityInjector.inject(Action.RESTORE);

        verify(bundle).describeContents();
    }

    @Test
    public void shouldSaveFieldValueToBundle() throws Exception {
        fragmentActivityInjector.inject(Action.SAVE);

        verify(bundle).describeContents();
    }

    static class ClassToInject {
    }

    static class ClassToInject$$Icepick {

        public static void saveInstanceState(ClassToInject target, Bundle outState) {
            outState.describeContents();
        }

        public static void restoreInstanceState(ClassToInject target, Bundle saveInstanceState) {
            saveInstanceState.describeContents();
        }
    }
}
