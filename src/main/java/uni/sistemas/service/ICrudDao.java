package uni.sistemas.service;


import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public interface ICrudDao<T> {
    
    void create (T e) throws Exception;
    void update (T e) throws Exception;
    void delete (T e) throws Exception;
    List<T> readAll() throws Exception;
    T find(int e) throws Exception;

}
