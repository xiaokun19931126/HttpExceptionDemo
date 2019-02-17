package com.xiaokun.advance_practive.database.table;


/**
 * Created by 肖坤 on 2019/2/16.
 *
 * @author 肖坤
 * @date 2019/2/16
 */

public class UserBaseTable extends BaseTable {

    /**
     * 表名
     */
    public static final String TABLE_NAME = "User";

    /**
     * 表字段
     */
    public static final String ID = "userid";
    public static final String NICKNAME = "nickname";
    public static final String PHONE = "phone";
    public static final String GENDER = "gender";
    public static final String NAME = "name";

    /**
     * 字段对应的columnIndex
     */
    public static final int ID_COLUMN_INDEX = 0;
    public static final int NICKNAME_COLUMN_INDEX = 1;
    public static final int PHONE_COLUMN_INDEX = 2;
    public static final int GENDER_COLUMN_INDEX = 3;
    public static final int NAME_COLUMN_INDEX = 4;

    /**
     * 创建表sql
     */
    public static final String CREATE_TABLE = "create table if not exists " + TABLE_NAME + "(" +
            ID + INTEGER_TYPE + PRIMARY_KEY + AUTOINCREMENT + COMMA_SEP +
            NICKNAME + TEXT_TYPE_SEP +
            PHONE + TEXT_TYPE_SEP +
            GENDER + INTEGER_TYPE_SEP +
            NAME + TEXT_TYPE + ")";

}
