/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecurosHumanos.ufpb.RecurosHumanos.Exceptions;

/**
 *
 * @author user
 */
public class CargoJaExisteException extends Exception{
    public CargoJaExisteException (String mensagem){
              super (mensagem);
     }
}
