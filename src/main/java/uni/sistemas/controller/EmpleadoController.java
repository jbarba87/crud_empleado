/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.sistemas.controller;

import java.util.List;
import uni.sistemas.entity.Empleado;
import uni.sistemas.model.EmpleadoDaoFile;

/**
 *
 * @author jorge
 */
public class EmpleadoController {
    
    EmpleadoDaoFile dao;

    public EmpleadoController() {
        
        dao = new EmpleadoDaoFile();
        
    }


    public void EmpleadoAdicionar(Empleado x) throws Exception{
        dao.create(x);
    }
        
    public void EmpleadoActualizar(Empleado x) throws Exception{
        dao.update(x);
    }
    public void EmpleadoEliminar(Empleado x) throws Exception{
        dao.delete(x);
    }
    public Empleado EmpleadoBuscar(int x) throws Exception{
        return dao.find(x);
    }
    public List<Empleado> EmpleadoListar() throws Exception{
        return dao.readAll();
    }
        
}
