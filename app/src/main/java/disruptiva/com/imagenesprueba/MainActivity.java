package disruptiva.com.imagenesprueba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ImageView imagenSeleccionada;
    Gallery gallery;

    ArrayList<ItemsDatosProductos>arrayList = new ArrayList<ItemsDatosProductos>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        imagenSeleccionada = (ImageView) findViewById(R.id.imagen_seleccionada);
        final TextView nombreProducto = (TextView) findViewById(R.id.nombre_seleccionada);
        final TextView tiempo = (TextView) findViewById(R.id.txtTiempoSeleccionado);
        final TextView precio = (TextView) findViewById(R.id.txtPrecioSeleccionado);
        final TextView descrpcion = (TextView) findViewById(R.id.txtDescripcionSeleccionada);

        arrayList.clear();
        arrayList.add(new ItemsDatosProductos( R.drawable.a, "Cafe Expres", "30 minutos","$20.000","Un menú es la lista de las comidas y bebidas que se sirven en un restaurante.  Cada comida del menú suele estar acompañada por una breve descripción de sus ingredientes, además del precio que debemos pagar por ella"));
        arrayList.add(new ItemsDatosProductos( R.drawable.b, "Cafe Colombiano", "10 minutos","$30.000","Un menú es la lista de las comidas y bebidas que se sirven en un restaurante.  Cada comida del menú suele estar acompañada por una breve descripción de sus ingredientes, además del precio que debemos pagar por ella"));
        arrayList.add(new ItemsDatosProductos( R.drawable.c, "Chorizo", "25 minutos","$40.000","Un menú es la lista de las comidas y bebidas que se sirven en un restaurante.  Cada comida del menú suele estar acompañada por una breve descripción de sus ingredientes, además del precio que debemos pagar por ella"));
        arrayList.add(new ItemsDatosProductos( R.drawable.d, "Churrasco", "15 minutos","$50.000","Un menú es la lista de las comidas y bebidas que se sirven en un restaurante.  Cada comida del menú suele estar acompañada por una breve descripción de sus ingredientes, además del precio que debemos pagar por ella"));
        arrayList.add(new ItemsDatosProductos( R.drawable.e, "Empanada", "5 minutos","$60.000","Un menú es la lista de las comidas y bebidas que se sirven en un restaurante.  Cada comida del menú suele estar acompañada por una breve descripción de sus ingredientes, además del precio que debemos pagar por ella"));
        arrayList.add(new ItemsDatosProductos( R.drawable.f, "Helado", "4 minutos","$70.000","Un menú es la lista de las comidas y bebidas que se sirven en un restaurante.  Cada comida del menú suele estar acompañada por una breve descripción de sus ingredientes, además del precio que debemos pagar por ella"));
        arrayList.add(new ItemsDatosProductos( R.drawable.g, "Te", "1 minutos","$80.000","Un menú es la lista de las comidas y bebidas que se sirven en un restaurante.  Cada comida del menú suele estar acompañada por una breve descripción de sus ingredientes, además del precio que debemos pagar por ella"));

        gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(new GalleryAdapter(this, arrayList));
        //al seleccionar una imagen, la mostramos en el centro de la pantalla a mayor tamaño

        Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(),arrayList.get(0).getImagen());
        imagenSeleccionada.setImageBitmap(bitmap);

        nombreProducto.setText(arrayList.get(0).getNombreP());
        tiempo.setText(arrayList.get(0).getTiempo());
        precio.setText(arrayList.get(0).getPrecio());
        descrpcion.setText(arrayList.get(0).getDescripcion());
        //con este listener, sólo se mostrarían las imágenes sobre las que se pulsa
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView parent, View v, int position, long id)
            {
                Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(),arrayList.get(position).getImagen());
                imagenSeleccionada.setImageBitmap(bitmap);

                nombreProducto.setText(arrayList.get(position).getNombreP());
                tiempo.setText(arrayList.get(position).getTiempo());
                precio.setText(arrayList.get(position).getPrecio());
                descrpcion.setText(arrayList.get(position).getDescripcion());
                //imagenSeleccionada.setImageBitmap(BitmapUtils.decodeSampledBitmapFromResource(getResources(), imagenes[position], 300, 0));
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
