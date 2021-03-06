package com.xiaokun.advance_practive.im.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.xiaokun.advance_practive.im.database.DatabaseHelper;
import com.xiaokun.advance_practive.im.database.table.UserTable;
import com.xiaokun.advance_practive.im.database.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 肖坤 on 2019/2/16.
 *
 * @author 肖坤
 * @date 2019/2/16
 */

public class UserDao {

    private static final String TAG = "UserDao";
    private SQLiteDatabase mDb;

    private UserDao() {
        this.mDb = DatabaseHelper.getDatabase();
    }

    public static UserDao getInstance() {
        return UserDaoHolder.sInstance;
    }

    private static class UserDaoHolder {
        private static final UserDao sInstance = new UserDao();
    }

    public boolean insert(User user) {
        if (user == null) {
            return false;
        }
        ContentValues values = new ContentValues();
        values.put(UserTable.ID, user.getUserId());
        values.put(UserTable.NAME, user.name);
        values.put(UserTable.NICKNAME, user.nickName);
        values.put(UserTable.PHONE, user.phone);
        values.put(UserTable.GENDER, user.gender);
        values.put(UserTable.USER_IM_ID, user.userImId);
        long result = mDb.replace(UserTable.TABLE_NAME, null, values);
        return result != -1;
    }

    public boolean deleteAll() {
        int result = mDb.delete(UserTable.TABLE_NAME, null, null);
        return result != -1;
    }

    public User queryCurrentUser() {
        Cursor cursor = mDb.query(UserTable.TABLE_NAME, null,
                null, null, null, null, null);
        List<User> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            User user = new User();
            user.nickName = cursor.getString(UserTable.NICKNAME_COLUMN_INDEX);
            user.phone = cursor.getString(UserTable.PHONE_COLUMN_INDEX);
            user.gender = cursor.getInt(UserTable.GENDER_COLUMN_INDEX);
            user.name = cursor.getString(UserTable.NAME_COLUMN_INDEX);
            user.userImId = cursor.getString(UserTable.USER_IM_ID_COLUMN_INDEX);
            list.add(user);
        }
        cursor.close();
        return list.isEmpty() ? null : list.get(list.size() - 1);
    }

}
