package com.example.tmd.sqlite_db.SQLite_DB.ContactByCommand;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tmd.sqlite_db.SQLite_DB.Contact;
import com.example.tmd.sqlite_db.SQLite_DB.InfoContactDatabase;

import java.util.ArrayList;

/**
 * Created by tmd on 23/04/2017.
 */

public class _CRUDHelper extends DatabaseHelper {

    public _CRUDHelper(Context context) {
        super(context);
    }

    public void getAllContact(ArrayList<Contact> mList) {
        mList.clear();// xóa hết dữ liệu cũ của mList không thì sẽ bị lặp
        SQLiteDatabase database = getWritableDatabase();
        String[] columns = new String[]{
                InfoContactDatabase.ContactEntry._ID,
                InfoContactDatabase.ContactEntry.COLUMN_NAME,
                InfoContactDatabase.ContactEntry.COLUMN_PHONE,
                InfoContactDatabase.ContactEntry.COLUMN_ADDRESS
        };

        // Android sqlite method
        Cursor cursor = database.query(InfoContactDatabase.ContactEntry.TABLE_NAME,
                columns, // columns
                null, // sellection
                null, // sellection args
                null, // group by
                null, // group by args
                null, // having
                null);// limit

        // sql command
//            Cursor cursor = database.rawQuery("SELECT * FROM Contact", null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(
                        cursor.getColumnIndex(InfoContactDatabase.ContactEntry._ID));
                String name = cursor.getString(
                        cursor.getColumnIndex(InfoContactDatabase.ContactEntry.COLUMN_NAME));
                String phone = cursor.getString(
                        cursor.getColumnIndex(InfoContactDatabase.ContactEntry.COLUMN_PHONE));
                String address = cursor.getString(
                        cursor.getColumnIndex(InfoContactDatabase.ContactEntry.COLUMN_ADDRESS));
                Contact contact = new Contact(id, name, phone, address);
                mList.add(contact);
            }
        }
        cursor.close();
        database.close();
    }

    public boolean insertContact(Contact contact) {
        // sqlite method
        {
            SQLiteDatabase database = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(InfoContactDatabase.ContactEntry.COLUMN_NAME, contact.getName());
            values.put(InfoContactDatabase.ContactEntry.COLUMN_PHONE, contact.getPhone());
            values.put(InfoContactDatabase.ContactEntry.COLUMN_ADDRESS, contact.getAddress());
            long result = database.insert(
                    InfoContactDatabase.ContactEntry.TABLE_NAME,
                    null, values);// return ID of new row
            /*
            - Xử lý ID:
                Vì _ID của database tự động tăng nên khi ta tự tạo Contact thì không thể biết được _ID của DB
                => Sau khi insert, để in danh sách mới cập nhật lên recyclerView
                thì phải getAllContact() nếu không thì _ID (in ra) sẽ bị sai.
                Vì mList.add(newContact) add phải contact chứa ID của chúng ta (không phải _ID của DB)
                Nếu muốn chỉ cần mList.add(newContact) thì phải cập nhật lại ID của contact bằng cách sử dụng result
            */
            if (result >= 0) {
                contact.setId(result);
            }

            database.close();
            return result >= 0;
        }

        // sql command
        // Không nên dùng vì không có quản lý được giá trị trả về
    }

    public int deleteContact(Contact contact) {
        SQLiteDatabase database = getWritableDatabase();
        String whereClause = InfoContactDatabase.ContactEntry._ID + " = ?";
        String[] whereAgrs = {contact.getId() + ""};
        int numRowAffected = database.delete(InfoContactDatabase.ContactEntry.TABLE_NAME, whereClause, whereAgrs);
        database.close();
        return numRowAffected;
    }

    public int ALL_deleteContact() {
        SQLiteDatabase database = getWritableDatabase();
        int numRowAffected = database.delete(InfoContactDatabase.ContactEntry.TABLE_NAME, null, null);
        database.close();
        return numRowAffected;
    }

    public int updateContact(Contact contact) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InfoContactDatabase.ContactEntry.COLUMN_NAME, contact.getName());
        values.put(InfoContactDatabase.ContactEntry.COLUMN_PHONE, contact.getPhone());
        values.put(InfoContactDatabase.ContactEntry.COLUMN_ADDRESS, contact.getAddress());

        String whereClause = InfoContactDatabase.ContactEntry._ID + " = ?";
        String[] whereAgrs = {contact.getId() + ""};
        int numRowAffected = database.update(InfoContactDatabase.ContactEntry.TABLE_NAME,
                values, whereClause, whereAgrs);
        database.close();
        return numRowAffected;
    }

    public int ALL_updateContact() {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InfoContactDatabase.ContactEntry.COLUMN_NAME, "TMD");
        values.put(InfoContactDatabase.ContactEntry.COLUMN_PHONE, "01669870048");
        values.put(InfoContactDatabase.ContactEntry.COLUMN_ADDRESS, "BAC GIANG");
        int numRowAffected = database.update(InfoContactDatabase.ContactEntry.TABLE_NAME, values, null, null);
        database.close();
        return numRowAffected;
    }
}

