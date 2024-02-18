/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bancodelsol.validaciones;

import bancodelsoldominio.Cliente;
import bancodelsolpersistencia.excepciones.PersistenciaException;
import bancodelsolpersistencia.excepciones.ValidacionDTOException;

/**
 *
 * @author
 */
public interface IValidacion {

    boolean existeUsuario(String usuario) throws ValidacionDTOException, PersistenciaException;

    Cliente existeCliente(Long idCliente) throws PersistenciaException;

    boolean clienteValido(String usuario, String contrasena) throws ValidacionDTOException;

}
