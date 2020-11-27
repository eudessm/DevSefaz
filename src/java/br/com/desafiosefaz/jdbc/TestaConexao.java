/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desafiosefaz.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author eudes
 */
public class TestaConexao {
    
    public static void main(String[] args) {
        
        try {
            new ConnectionFactory().getConnetion();
            JOptionPane.showMessageDialog(null,"Conectado");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"Não Conectado Motivo:" + erro);
        }
    }
    
}
