package es.rufflecol.lara.tutorialstartscreenandsidemenu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;

public class TutorialActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));

        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        button = (Button) findViewById(R.id.doneButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TutorialActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences settings = getSharedPreferences("prefs", 0);
        boolean firstRun = settings.getBoolean("firstRun", false);
        if (firstRun == false)
        {
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("firstRun", true);
            editor.commit();
        } else {
            Intent startMainActivity = new Intent(this, MainActivity.class);
            startActivity(startMainActivity);
        }
    }
}