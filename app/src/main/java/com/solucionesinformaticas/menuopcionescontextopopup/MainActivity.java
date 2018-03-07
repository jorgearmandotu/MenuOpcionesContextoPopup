package com.solucionesinformaticas.menuopcionescontextopopup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvNombrePersona = (TextView) findViewById(R.id.tvNombrePersona);
        TextView tvApellido = (TextView) findViewById(R.id.tvApellido);
        registerForContextMenu(tvNombrePersona);
        registerForContextMenu(tvApellido);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;
            case R.id.mSettings:
                Intent i = new Intent(this, ActivitySettings.class);
                startActivity(i);
                break;
            case R.id.mSearch:
                Toast.makeText(this,getResources().getString(R.string.menu_search), Toast.LENGTH_SHORT).show();
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = new MenuInflater(this);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

         switch (item.getItemId()){
             case R.id.mEdit:
                 Toast.makeText(this, getResources().getString(R.string.mensaje_edit), Toast.LENGTH_SHORT).show();
                 break;
             case R.id.mDelete:
                 Toast.makeText(this, getResources().getString(R.string.mensaje_delete), Toast.LENGTH_SHORT).show();
                 break;
         }
        return super.onContextItemSelected(item);
    }

    public void levantarMenuPopup(View v){
        ImageView imagen = (ImageView) findViewById(R.id.imgImagen);
        PopupMenu poppupmenu = new PopupMenu(this, imagen);
        poppupmenu.getMenuInflater().inflate(R.menu.menu_popup, poppupmenu.getMenu());

        poppupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.mview:
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.menu_view), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mViewDetail:
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.menu_detalle), Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        poppupmenu.show();
    }
}
