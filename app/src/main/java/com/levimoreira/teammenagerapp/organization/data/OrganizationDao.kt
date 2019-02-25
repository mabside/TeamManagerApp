package com.levimoreira.teammenagerapp.organization.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.application.entities.Person
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface OrganizationDao {
    @Query("SELECT * from " + Organization.TABLE_NAME)
    fun getAll(): Single<List<Organization>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(org: Organization): Long

    @Query("SELECT * FROM " + Organization.TABLE_NAME + " WHERE id = :orgId")
    fun getOrganizationById(orgId: Long): Maybe<Organization>

    @Query("DELETE FROM " + Organization.TABLE_NAME + " WHERE id = :org")
    fun deleteById(org: Long): Int
}