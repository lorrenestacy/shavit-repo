package com.example.lorreneogbonna.shavit.Controller;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.example.lorreneogbonna.shavit.Model.Cliente;
import com.example.lorreneogbonna.shavit.Model.Clinica;
import com.example.lorreneogbonna.shavit.MyDao;

@Database(entities = {Clinica.class, Cliente.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    private static MyDatabase INSTANCE;

    public abstract MyDao myDao();

    private static final Object slock = new Object();
    @VisibleForTesting
    static final Migration MIGRATION1_2 = new Migration(1,2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            //something
        }
    };

    public static MyDatabase getInstance(Context context){
        synchronized (slock){
    //        if (INSTANCE==null){
    //            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
    //                    MyDatabase.class, "db").addMigrations(MIGRATION1_2).build();
    //        }
    //        return INSTANCE;
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "db")
                                // allow queries on the main thread.
                                // Don't do this on a real app! See PersistenceBasicSample for an example.
                                .allowMainThreadQueries()
                                .build();
            }
            return INSTANCE;
        }
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
