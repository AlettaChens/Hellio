package com.zencloud.wordchen.rxredemo.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface MikeDao {

	@Query("SELECT * FROM mike")
	List<Mike> getAllMikes();


	@Query("SELECT * FROM mike where ID = :id")
	Mike getMikeById(int id);

	@Insert
	void insertAll(ArrayList<Mike> mikes);

	@Delete
	void deleteAll(List<Mike> mikes);

	@Update
	void updateMikes(Mike... books);

}

