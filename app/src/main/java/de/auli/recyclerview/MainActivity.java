package de.auli.recyclerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    public static List<Person> personArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Objekte anlegen
        personArrayList = new ArrayList<>();
        personArrayList.addAll(Arrays.asList(
               new Person("Frank", "Berlin"),
               new Person("Annette", "Hameln"),
               new Person("Bernd", "Berlin"),
               new Person("Emil", "Hamburg"),
               new Person("Hein Mück", "Bremen"),
               new Person("Resi", "München")));

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
            }

            @Override
            public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
                RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
                Paint paintCyan = new Paint(Paint.ANTI_ALIAS_FLAG);
                paintCyan.setColor(Color.CYAN);
                paintCyan.setStyle(Paint.Style.STROKE);
                paintCyan.setStrokeWidth(5);
                for(int i=0;i<parent.getChildCount();i++){
                    View child = parent.getChildAt(i);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        c.drawRoundRect(layoutManager.getDecoratedLeft(child)+10,
                                layoutManager.getDecoratedTop(child)+ 10,
                                layoutManager.getDecoratedRight(child)-10,
                                layoutManager.getDecoratedBottom(child)-10,15,15,paintCyan);
                    }
                }
            }
        });


        recyclerView = findViewById(R.id.id_recyclerview);
        recyclerViewLayoutManager = new GridLayoutManager(this, 3);
        recyclerViewAdapter = new MyRecyclerViewAdapter();
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        //dividerItemDecoration= new DividerItemDecoration(recyclerView.getContext(), 1);

    }


}
