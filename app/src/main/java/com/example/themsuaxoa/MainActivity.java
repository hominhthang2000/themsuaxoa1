package com.example.themsuaxoa;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvAmNhac;
    Button  btnThem;
    EditText edtamnhac;
    Button btnsua;

    ArrayList<String> arrayCourse;
    int vitri = -1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThem=(Button) findViewById(R.id.buton1) ;
        edtamnhac=(EditText) findViewById(R.id.edittext1);
        lvAmNhac=(ListView) findViewById(R.id.listviewAmNhac);
        btnsua=(Button)findViewById(R.id.buton2);
        arrayCourse= new ArrayList<>();
        arrayCourse.add("Khiêu Vũ");
        arrayCourse.add("Nhạc Kháng Chiến");
        arrayCourse.add("Nhạc Phim");
        arrayCourse.add("Nhạc Game");
        arrayCourse.add("Ngâm Thơ");
        arrayCourse.add("Bóng Rổ");
        arrayCourse.add("Chạy Bộ");
        arrayCourse.add("Đọc sách ");
        arrayCourse.add("Ngủ Nướng");
        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayCourse);
        lvAmNhac.setAdapter(adapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amnhac= edtamnhac.getText().toString();
                arrayCourse.add(amnhac);
                adapter.notifyDataSetChanged();
            }
        });
        lvAmNhac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtamnhac.setText(arrayCourse.get(i));
                vitri=i;
            }
        });
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri,edtamnhac.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lvAmNhac.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayCourse.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Đã Xóa Thành Công", Toast.LENGTH_LONG).show();
                return false;
           }
        });
            }
}