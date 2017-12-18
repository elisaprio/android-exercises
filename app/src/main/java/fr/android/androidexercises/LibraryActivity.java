package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView messageTextView = findViewById(R.id.messageTextView);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request
                .Builder()
                .url("https://api.github.com/users/elisaprio")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Does nothing but could log error
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    final JSONObject user = new JSONObject(response.body().string());
                    runOnUiThread(() -> {
                        try {
                            messageTextView.setText(
                                    getString(R.string.hello, user.get("name"))
                            );
                        } catch (JSONException ignored) {
                            // Ignored but could be logged
                        }
                    });
                } catch (JSONException ignored) {
                    // Ignored but could be logged
                }
            }
        });
    }
}
