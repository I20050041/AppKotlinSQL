package com.example.kotlinconsql

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConnectSql {
    private val serverName = "192.168.100.28"
    private val db = "KotlinDB"
    private val username = "sa"
    private val password = "12345678"

    fun dbConn(): Connection? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn: Connection? = null
        val connString: String
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver")
            connString = "jdbc:jtds:sqlserver://$serverName;databaseName=$db;user=$username;password=$password"
            conn = DriverManager.getConnection(connString)
        } catch (ex: SQLException) {
            Log.e("Error: ", ex.message!!)
        } catch (ex1: ClassNotFoundException) {
            Log.e("Error: ", ex1.message!!)
        } catch (ex2: ClassNotFoundException) {
            Log.e("Error: ", ex2.message!!)
        }
        return conn
    }
}