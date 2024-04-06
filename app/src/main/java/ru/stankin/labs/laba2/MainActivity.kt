package ru.stankin.labs.laba2

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var contactsListView: ListView
    private lateinit var contactsList: ArrayList<String>

    companion object {
        private const val PERMISSION_REQUEST_READ_CONTACTS = 100
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactsListView = findViewById(R.id.contactsListView)
        contactsList = ArrayList()

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                PERMISSION_REQUEST_READ_CONTACTS
            )
        } else {
            loadContacts()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_READ_CONTACTS -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadContacts()
                } else {
                    Toast.makeText(
                        this,
                        "Permission Denied",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return
            }
        }
    }

    @SuppressLint("Range")
    private fun loadContacts() {
        val contentResolver: ContentResolver = contentResolver
        val cursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            null
        )

        cursor?.let {
            while (it.moveToNext()) {
                val contactName =
                    it.getString(it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                contactsList.add(contactName)
            }
            it.close()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactsList)
        contactsListView.adapter = adapter
    }
}