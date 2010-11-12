/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacao;

/**
 *
 * @author matheusmf
 */
public class ShoppingVirtual {
    private static ShoppingVirtual sV = new ShoppingVirtual();
    private Fabrica fabrica = Fabrica.getInstancia();

    private ShoppingVirtual(){

    }

    public static ShoppingVirtual getInstancia(){
        return ShoppingVirtual.sV;
    }

}
