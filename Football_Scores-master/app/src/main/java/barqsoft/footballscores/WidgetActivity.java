package barqsoft.footballscores;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Created by marlonrouse on 28/10/2015.
 */
public class WidgetActivity extends AppWidgetProvider {

    public static WidgetMatch match;

    public void onUpdate(Context context, AppWidgetManager appWidgetManager,int[] appWidgetIds) {
        if (match != null) {
            Log.i("WidgetActivity", "onUpdate()" + match.toString());
        }
        for(int i=0; i<appWidgetIds.length; i++){
            int currentWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
            if (match!=null) {
                views.setTextViewText(R.id.home_name, match.getHomeName());
                views.setTextViewText(R.id.away_name, match.getAwayName());
                views.setImageViewResource(R.id.home_crest, Utilies.getTeamCrestByTeamName(match.getHomeName()));
                views.setImageViewResource(R.id.away_crest, Utilies.getTeamCrestByTeamName(match.getAwayName()));
                views.setTextViewText(R.id.score_textview, match.getHomeGoals() + " - " + match.getAwayGoals());
                views.setTextViewText(R.id.data_textview, match.getTime());
            }
            appWidgetManager.updateAppWidget(currentWidgetId, views);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("WidgetActivity", "onReceive()");
        super.onReceive(context, intent);
        if (intent.getParcelableExtra("the_match") != null) {
            Log.i("WidgetActivity", "set match");
            match = intent.getParcelableExtra("the_match");
        }
    }
}
