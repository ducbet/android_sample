package com.example.tmd.optionmenu_p.BTVN;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by tmd on 18/04/2017.
 */

public class ContactDataSource extends DatabaseHelper {

    public ContactDataSource(Context context) {
        super(context);
    }

    // 1) get all contact from db
    public ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> result = new ArrayList<>();
        String[] columns = {ContactContract.ContactEntry._ID,
                ContactContract.ContactEntry.COLUMN_NAME,
                ContactContract.ContactEntry.COLUMN_ADDRESS,
                ContactContract.ContactEntry.COLUMN_PHONE};
        String orderBy = ContactContract.ContactEntry._ID + "DESC";
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.query(ContactContract.ContactEntry.TABLE_NAME,
                columns, // columns
                null, // collection
                null, // colection args
                null, // group by
                null, // group by args
                null, // having
                null);// limit

        if (cursor != null && cursor.moveToFirst()) {
            // co du lieu
            do {
                int id = cursor.getInt(
                        cursor.getColumnIndex(ContactContract.ContactEntry._ID));
                String name = cursor.getString(
                        cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_NAME));
                String phone = cursor.getString(
                        cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_PHONE));
                String address = cursor.getString(
                        cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_ADDRESS));
                Contact contact = new Contact(id, name, phone, address);
                result.add(contact);
            } while (cursor.moveToNext());
        }
        // khong co du lieu

        database.close();

        return result;
    }

    public boolean insertContact(Contact contact) {
        // TODO: 17/04/2017

        // 1) open database
        SQLiteDatabase database = getWritableDatabase();

        // 2) Khai bao content value

        ContentValues values = new ContentValues();
        values.put(ContactContract.ContactEntry.COLUMN_NAME, contact.getName());
        values.put(ContactContract.ContactEntry.COLUMN_PHONE, contact.getPhone());
        values.put(ContactContract.ContactEntry.COLUMN_ADDRESS, contact.getAddress());
        long result = database.insert(ContactContract.ContactEntry.TABLE_NAME, null, values);

        database.close();

        return result >= 0;
    }

    public boolean deleteContact(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String whereClause = ContactContract.ContactEntry._ID + " = ?";
        String[] whereArgs = {String.valueOf(id)};

        long result = database.delete(ContactContract.ContactEntry.TABLE_NAME,
                whereClause, whereArgs);

        database.close();
        return result >= 0;
    }

    public boolean updateContact(Contact contact){
        SQLiteDatabase database = getWritableDatabase();

        String whereClause = ContactContract.ContactEntry._ID + " = ? ";
        String[] whereArgs = {String.valueOf(contact.getID())};

        ContentValues values = new ContentValues();
        values.put(ContactContract.ContactEntry.COLUMN_NAME, contact.getName());
        values.put(ContactContract.ContactEntry.COLUMN_PHONE, contact.getPhone());
        values.put(ContactContract.ContactEntry.COLUMN_ADDRESS, contact.getAddress());
        int result = database.update(ContactContract.ContactEntry.TABLE_NAME, values, null, null);

        database.close();
        return result > 0;
    }
}
