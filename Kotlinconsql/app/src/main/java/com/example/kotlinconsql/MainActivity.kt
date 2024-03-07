package com.example.kotlinconsql

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import java.sql.PreparedStatement
import java.sql.SQLException

lateinit var CajitaNombre: EditText
lateinit var CajitaCodigo: EditText
lateinit var  Boton: Button

class MainActivity : ComponentActivity() {

    private var connectSql = ConnectSql()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CajitaNombre = findViewById(R.id.txtNombre)
        CajitaCodigo = findViewById(R.id.txtCodigo)
        Boton = findViewById(R.id.btnEnviar)

        Boton.setOnClickListener {
            try {
                val addEstudiante: PreparedStatement = connectSql.dbConn()?.prepareStatement("insert into Estudiantes values ('"+ CajitaNombre.text.toString() +"','"+ CajitaCodigo.text.toString()+"')")!!
            addEstudiante.executeUpdate()
            Toast.makeText(this, "Estudiante ingresado correctamente", Toast.LENGTH_SHORT).show()
            }catch (ex: SQLException){
            Toast.makeText(this,"Error al ingresar", Toast.LENGTH_SHORT).show()
        }
    }
}
}
