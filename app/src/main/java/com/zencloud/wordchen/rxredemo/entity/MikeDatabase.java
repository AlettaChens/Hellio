package com.zencloud.wordchen.rxredemo.entity;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Mike.class}, version = 1,exportSchema = false)
public abstract class MikeDatabase extends RoomDatabase {
	private static volatile MikeDatabase INSTANCE;
	public abstract MikeDao mikeDao();

	public static MikeDatabase getInstance(Context context) {
		if (INSTANCE == null) {
			synchronized (MikeDatabase.class) {
				if (INSTANCE == null) {
					INSTANCE = Room.databaseBuilder(context,
							MikeDatabase.class, "mike.db")
							.build();
				}
			}
		}
		return INSTANCE;
	}
}
