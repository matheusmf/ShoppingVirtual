/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernatetutorial;

import hibernatetutorial.controladoresJPA.AlunoJpaController;

/**
 *
 * @author matheusmf
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Aluno a1 = new Aluno();
        a1.setNome("Matheus");
        a1.setIdade(21);
        
        AlunoJpaController a1Jpa = new AlunoJpaController();

        a1Jpa.create(a1);
    }

}
