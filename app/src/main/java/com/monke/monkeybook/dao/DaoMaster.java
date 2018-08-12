package com.monke.monkeybook.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.identityscope.IdentityScopeType;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/**
 * Master of DAO (schema version 31): knows all DAOs.
 */
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 31;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(Database db, boolean ifNotExists) {
        BookInfoBeanDao.createTable(db, ifNotExists);
        BookmarkBeanDao.createTable(db, ifNotExists);
        BookShelfBeanDao.createTable(db, ifNotExists);
        BookSourceBeanDao.createTable(db, ifNotExists);
        ChapterListBeanDao.createTable(db, ifNotExists);
        DownloadChapterBeanDao.createTable(db, ifNotExists);
        ReplaceRuleBeanDao.createTable(db, ifNotExists);
        SearchBookBeanDao.createTable(db, ifNotExists);
        SearchHistoryBeanDao.createTable(db, ifNotExists);
    }

    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(Database db, boolean ifExists) {
        BookInfoBeanDao.dropTable(db, ifExists);
        BookmarkBeanDao.dropTable(db, ifExists);
        BookShelfBeanDao.dropTable(db, ifExists);
        BookSourceBeanDao.dropTable(db, ifExists);
        ChapterListBeanDao.dropTable(db, ifExists);
        DownloadChapterBeanDao.dropTable(db, ifExists);
        ReplaceRuleBeanDao.dropTable(db, ifExists);
        SearchBookBeanDao.dropTable(db, ifExists);
        SearchHistoryBeanDao.dropTable(db, ifExists);
    }

    /**
     * WARNING: Drops all table on Upgrade! Use only during development.
     * Convenience method using a {@link DevOpenHelper}.
     */
    public static DaoSession newDevSession(Context context, String name) {
        Database db = new DevOpenHelper(context, name).getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }

    public DaoMaster(SQLiteDatabase db) {
        this(new StandardDatabase(db));
    }

    public DaoMaster(Database db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(BookInfoBeanDao.class);
        registerDaoClass(BookmarkBeanDao.class);
        registerDaoClass(BookShelfBeanDao.class);
        registerDaoClass(BookSourceBeanDao.class);
        registerDaoClass(ChapterListBeanDao.class);
        registerDaoClass(DownloadChapterBeanDao.class);
        registerDaoClass(ReplaceRuleBeanDao.class);
        registerDaoClass(SearchBookBeanDao.class);
        registerDaoClass(SearchHistoryBeanDao.class);
    }

    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }

    /**
     * Calls {@link #createAllTables(Database, boolean)} in {@link #onCreate(Database)} -
     */
    public static abstract class OpenHelper extends DatabaseOpenHelper {
        public OpenHelper(Context context, String name) {
            super(context, name, SCHEMA_VERSION);
        }

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(Database db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }

    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name) {
            super(context, name);
        }

        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

}
