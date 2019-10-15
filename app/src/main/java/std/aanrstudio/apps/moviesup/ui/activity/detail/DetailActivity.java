package std.aanrstudio.apps.moviesup.ui.activity.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import std.aanrstudio.apps.moviesup.R;
import std.aanrstudio.apps.moviesup.data.source.model.Movie;
import std.aanrstudio.apps.moviesup.data.source.model.Tv;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_INTENT = "extra_intent";
    private ImageView poster;
    private TextView title;
    private TextView age;
    private TextView category;
    private TextView duration;
    private TextView overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        poster = findViewById(R.id.detail_poster);
        title = findViewById(R.id.detail_title);
        age = findViewById(R.id.detail_age);
        category = findViewById(R.id.detail_category);
        duration = findViewById(R.id.detail_duration);
        overview = findViewById(R.id.detail_overview);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        int x = getIntent().getExtras().getInt(EXTRA_ID, 0);
        String extraIntent = getIntent().getExtras().getString(EXTRA_INTENT);

        DetailViewModel detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        detailViewModel.setPosition(x);

        if (extraIntent.equals("Movie")) {
            getMovie(detailViewModel.getMovies());
        } else if (extraIntent.equals("Tv")) {
            getTv(detailViewModel.getTv());
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getTv(Tv tv) {
        title.setText(tv.getTitle());
        age.setText(tv.getAge());
        category.setText(tv.getGenre());
        duration.setText(tv.getDuration());
        overview.setText(tv.getOverview());
        poster.setImageResource(tv.getPoster());
    }

    private void getMovie(Movie movie) {
        title.setText(movie.getTitle());
        age.setText(movie.getAge());
        category.setText(movie.getGenre());
        duration.setText(movie.getDuration());
        overview.setText(movie.getOverview());
        poster.setImageResource(movie.getPoster());
    }
}
