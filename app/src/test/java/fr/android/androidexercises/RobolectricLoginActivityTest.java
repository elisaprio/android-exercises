package fr.android.androidexercises;



import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class RobolectricLoginActivityTest {

    // TODO test login activity with Robolectric and Mockito
    LoginActivity loginActivity;

    @Before
    public void setUp() throws Exception {
        loginActivity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void name() throws Exception {
        //When
        loginActivity.notLogged();
        //Then
        Assertions.assertThat(loginActivity.loggedText).isGone();
        Assertions.assertThat(loginActivity.loginLayout).isVisible();
    }

}