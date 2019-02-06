/*
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank_Server;

/**
 *
 * @author Ronan
 */
public class InvalidSession extends Exception {
    public InvalidSession(String e){
		super(e);
	}
}
