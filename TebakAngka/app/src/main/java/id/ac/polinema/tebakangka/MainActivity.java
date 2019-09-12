package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
    private int input, randNumber;
    private Random random;
    private EditText inputForm;
    private Button guessBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
	    inputForm = findViewById(R.id.number_input);
	    guessBtn = findViewById(R.id.guess_button);
	    random = new Random();
	    initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
        randNumber = random.nextInt(100)+1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
	    String inputSting = inputForm.getText().toString();
	    String anotherString;
	    if(inputSting.equalsIgnoreCase(" ")){
	        Toast.makeText(this,"input harus angka", Toast.LENGTH_SHORT).show();
        }else{
	        input = Integer.parseInt(inputSting);
	        if(input > randNumber){
                Toast.makeText(this,"tebakan anda terlalu besar", Toast.LENGTH_SHORT).show();
            }else if(input < randNumber){
                Toast.makeText(this,"tebakan anda terlalu kecil", Toast.LENGTH_SHORT).show();
            }else if(input == randNumber){
                Toast.makeText(this,"tebakan anda benar", Toast.LENGTH_SHORT).show();
                guessBtn.setEnabled(false);
            }
        }
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
        inputForm.setText("");
        initRandomNumber();
        guessBtn.setEnabled(true);
	}
}
