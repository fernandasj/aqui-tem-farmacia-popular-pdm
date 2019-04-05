package ifpb.edu.br.appfarmaciapopular;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import ifpb.edu.br.appfarmaciapopular.helper.FarmaciaHelper;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InsertFarmaciasTest {
    FarmaciaHelper farmaciaHelper;

    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        farmaciaHelper = new FarmaciaHelper(appContext);
        Integer esperado = 28026;
        Integer valor = farmaciaHelper.countFarmacias();
        assertEquals(esperado, valor);
    }
}
