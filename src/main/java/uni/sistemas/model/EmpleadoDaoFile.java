/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.sistemas.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import uni.sistemas.entity.Empleado;
import uni.sistemas.service.ICrudDao;

/**
 *
 * @author jorge
 */
public class EmpleadoDaoFile implements ICrudDao<Empleado>{
    
    FileReader fr = null;
    FileWriter fw = null;
    PrintWriter pw = null;
    BufferedReader br = null;
    File f = null;
    String dato = null;
    String archivo = "Empleados.txt";
    String temporal = "Temporal.txt";

    
    @Override
    public void create(Empleado e) throws Exception {
        
        
        try{
            fw = new FileWriter(archivo, true);
            pw = new PrintWriter(fw);
            dato = e.getCodigo() + "#" + e.getNombre() + "#" + e.getCargo()  + "#" + e.getArea() + "#" + e.getSueldo()
                   + "#" + e.getDescuento() + "#" + e.getSueldo_neto()
                   + "\n";
            pw.write(dato);
            pw.close();
        
        
        } catch (IOException error) {
            throw error;
        } finally {
            fw.close();
        }

    }

    @Override
    public void update(Empleado e) throws Exception {
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String nuevomensaje = e.getCodigo() + "#" + e.getNombre() + "#" + e.getCargo()  + "#" + e.getArea() + "#" + e.getSueldo()
                   + "#" + e.getDescuento() + "#" + e.getSueldo_neto()
                   + "\n";
            String linea = br.readLine();
            while (linea != null) {
                StringTokenizer token = new StringTokenizer(linea, "#");
                String codigo = token.nextToken();
                if (Integer.parseInt(codigo) == e.getCodigo()) {
                    pw = new PrintWriter(new FileWriter(temporal, true));
                    pw.write(nuevomensaje);
                    pw.close();
                } else {
                    String lineatempo = linea + "\n";
                    pw = new PrintWriter(new FileWriter(temporal, true));
                    pw.write(lineatempo);
                    pw.close();
                }
                linea = br.readLine();
            }
            br.close();
            borrar_archivo(archivo);
            renombrar_archivo(archivo);
        } catch (IOException | NumberFormatException error) {
            throw error;
        }
    }

    @Override
    public void delete(Empleado e) throws Exception {
      try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String nuevomensaje = e.getCodigo() + "#" + e.getNombre() + "#" + e.getCargo()  + "#" + e.getArea() + "#" + e.getSueldo()
                   + "#" + e.getDescuento() + "#" + e.getSueldo_neto()
                   + "\n";
            String linea = br.readLine();
            while (linea != null) {
                StringTokenizer token = new StringTokenizer(linea, "#");
                String codigo = token.nextToken();
                if (Integer.parseInt(codigo) == e.getCodigo()) {
//                    pw = new PrintWriter(new FileWriter(temporal, true));
//                    pw.write(nuevomensaje);
//                    pw.close();
                } else {
                    String lineatempo = linea + "\n";
                    pw = new PrintWriter(new FileWriter(temporal, true));
                    pw.write(lineatempo);
                    pw.close();
                }
                linea = br.readLine();
            }
            br.close();
            borrar_archivo(archivo);
            renombrar_archivo(archivo);
        } catch (IOException | NumberFormatException error) {
            throw error;
        }    }

    @Override
    public List<Empleado> readAll() throws Exception {
        List<Empleado> lista = new ArrayList<>();
        try {
            //abrir archivo para lectura
            fr = new FileReader(archivo);
            //crear objeto para leer datos
            br = new BufferedReader(fr);
            // leer la primera linea
            dato = br.readLine();
            while (dato != null) {
                Empleado emp = new Empleado();
                // objeto para partien en pedasos el dato
                StringTokenizer token = new StringTokenizer(dato, "#");
                //asignar valores al objeto alu
                emp.setCodigo(Integer.parseInt(token.nextToken()));
                emp.setNombre(token.nextToken());
                emp.setCargo(token.nextToken());
                emp.setArea(token.nextToken());
                //adicionar a la coleccion
                emp.setSueldo(Double.parseDouble(token.nextToken()));
                emp.setDescuento(Double.parseDouble(token.nextToken()));
                emp.setSueldo_neto(Double.parseDouble(token.nextToken()));
                lista.add(emp);
                //lee el siguiente dato
                dato = br.readLine();
            }
            br.close();
        } catch (IOException | NumberFormatException error) {
            throw error;
        } finally {
            fr.close();
        }
        return lista;
    }

    @Override
    public Empleado find(int e) throws Exception {
        Empleado emp = null;
        try {
            //abrir archivo para lectura
            fr = new FileReader(archivo);
            //crear objeto para leer datos
            br = new BufferedReader(fr);
            // leer la primera linea
            dato = br.readLine();
            while (dato != null) {
                // objeto para partien en pedasos el dato
                StringTokenizer token = new StringTokenizer(dato, "#");
                int cod = Integer.parseInt(token.nextToken());
                if (cod == e) {
                    emp = new Empleado();
                    //asignar valores al objeto alu
                    emp.setCodigo(cod);
                    emp.setNombre(token.nextToken());
                    emp.setCargo(token.nextToken());
                    emp.setArea(token.nextToken());
                    emp.setSueldo(Double.parseDouble(token.nextToken()));
//                    emp.setDescuento(Double.parseDouble(token.nextToken()));
//                    emp.setSueldo_Neto(Double.parseDouble(token.nextToken()));

                }
                //lee el siguiente dato
                dato = br.readLine();
            }
            br.close();
        } catch (IOException | NumberFormatException error) {
            throw error;
        } finally {
            fr.close();
        }
        return emp;
    }

    private void borrar_archivo(String ruta) {
        // BORRAR ARCHIVO VIEJO
        String original = ruta;
        File arc = new File(original);
        if (arc.delete()) {
            System.out.println("Archivo Borrado");
        } else {
            System.out.println("No se pudo borrar");
        }
        // BORRAR ARCHIVO VIEJO
    }

    private void renombrar_archivo(String ruta) {
        // RENOMBRAR ARCHIVO temp.txt
        File nuevonombre = new File(ruta);
        File viejonombre = new File(temporal);
        if (viejonombre.renameTo(nuevonombre)) {
            System.out.println("No se pudo renombrar");
        }// RENOMBRAR ARCHIVO temp.txt

    }
}
