package ec.edu.tecnologicoloja.ventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_adivinar;
    EditText txt_color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_adivinar=(Button) findViewById(R.id.button);
        txt_color=(EditText) findViewById(R.id.TextColor);
    }
    public void clickBtn(View v){
        // Obtener el texto ingresado en el campo de texto y convertirlo a minúsculas
        String color = txt_color.getText().toString().toLowerCase();

        // Verifica que los colores sean los correctos
        if (isValidColor(color)) {
            // Crear un intent para abrir la actividad MainActivity2
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            // Pasar el texto del color como un extra en el intent
            intent.putExtra("color", color);
            // Iniciar la actividad MainActivity2
            startActivity(intent);
        } else {
            // Mostrar un mensaje de error con un Toast si el color no es válido
            Toast.makeText(getApplicationContext(), "❌ Error: no válido", Toast.LENGTH_SHORT).show();
        }
    }
    //Metodo boleano envia true si es correcto
    private boolean isValidColor(String color) {
        // Verificar si el color es rojo, azul o amarillo
        return color.equals("rojo") || color.equals("azul") || color.equals("amarillo");
    }
}