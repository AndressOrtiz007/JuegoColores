package ec.edu.tecnologicoloja.ventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private String randomColor,colorR;
    TextView texto;
    LinearLayout fondoColor,colorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Obtener el color seleccionado de la actividad anterior
        Bundle datos = getIntent().getExtras();
        colorR = datos.getString("color");
        texto=(TextView) findViewById(R.id.textView);
        fondoColor = findViewById(R.id.background);
        colorLayout = findViewById(R.id.colorelegido);

        // Establecer el color seleccionado como fondo del layout
        colorLayout.setBackgroundColor(Color.parseColor(colorExadecimal(colorR)));

        Toast.makeText(getApplicationContext(), "Color recibido: " + colorR, Toast.LENGTH_LONG).show();
        colorAleatorio();
        compararRespuesta();

    }
    public void colorAleatorio() {
        // Creamos un array con los colores disponibles
        String[] colores = {"rojo", "amarillo", "azul"};

        // Generamos un índice aleatorio para seleccionar un color del array
        int randomIndex = new Random().nextInt(colores.length);

        // Obtener el color aleatorio
        randomColor = colores[randomIndex];
        fondoColor.setBackgroundColor(Color.parseColor(colorExadecimal(randomColor)));
    }
    public void compararRespuesta(){
        // Comparar el color aleatorio con el color seleccionado
        if (randomColor.equalsIgnoreCase(colorR)) {
            // Mostrar mensaje de ganador en el TextView
            texto.setText("Ganaste \n El color es: " + randomColor);
        } else {
            // Mostrar mensaje de perdedor en el TextView
            texto.setText("Perdiste \n El color es: " + randomColor);
        }
    }
    public static String colorExadecimal(String color){
        String colorHexa;

        // Convertir el nombre del color en su representación hexadecimal
        switch (color.toLowerCase()) {
            case "azul":
                colorHexa = "#0000FF";
                break;
            case "rojo":
                colorHexa = "#FF0000";
                break;
            case "amarillo":
                colorHexa = "#FFFF00";
                break;
            default:
                colorHexa = "#000000";
                break;
        }
        return colorHexa;
    }
}