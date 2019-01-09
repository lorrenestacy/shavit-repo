package com.example.lorreneogbonna.shavit;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.lorreneogbonna.shavit.Model.Cliente;
import com.example.lorreneogbonna.shavit.Model.Clinica;

import java.util.List;

@Dao
public interface MyDao {
@Insert
    public void addCliente(Cliente cliente);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addClinica(Clinica clinica);
    @Query("SELECT * FROM clinicas")
    List<Cliente> getallclientes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllClientes(Cliente... clientes);
    @Query("SELECT * FROM clientes")
    List<Cliente> getallclinicas();

    @Insert
    void insertAllClinicas(Cliente... clinicas);



}
