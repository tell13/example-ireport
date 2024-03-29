package com.fabriciojf.view;

import com.fabriciojf.entidade.Usuario;
import com.fabriciojf.controle.UsuarioLogica;

/**
 * Frame de Usuario
 *
 * @author Fabricio S Costa http://fabriciojf.com
 * @since 25/10/2010
 * @version 1.0
 */
public class fUsuario extends javax.swing.JFrame {

    private UsuarioLogica usuarioLogica = new UsuarioLogica();

    /** Creates new form fUsuario */
    public fUsuario() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        edtNomeUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSalvarUsuario = new javax.swing.JToggleButton();
        btnPesqUsuario = new javax.swing.JToggleButton();
        edtIdUsuario = new javax.swing.JTextField();
        btnNovo = new javax.swing.JToggleButton();
        abrir = new javax.swing.JToggleButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        edtNomeUsuario.setEditable(false);

        jLabel1.setText("Código / Nome do Usuário :");

        btnSalvarUsuario.setText("Salvar");
        btnSalvarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuarioActionPerformed(evt);
            }
        });

        btnPesqUsuario.setText("Pesquisar");
        btnPesqUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqUsuarioActionPerformed(evt);
            }
        });

        edtIdUsuario.setEditable(false);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(abrir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(btnPesqUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvarUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvarUsuario)
                    .addComponent(btnPesqUsuario)
                    .addComponent(abrir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuarioActionPerformed
        salvar();
}//GEN-LAST:event_btnSalvarUsuarioActionPerformed

    private void btnPesqUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqUsuarioActionPerformed
        PesquisarUsuario pu = new PesquisarUsuario(this);
        pu.setVisible(true);
        pu.setLocationRelativeTo(null);
}//GEN-LAST:event_btnPesqUsuarioActionPerformed

    public void carregarUsuario(Usuario usuario) {
        edtIdUsuario.setText(String.valueOf(usuario.getId()));
        edtNomeUsuario.setText(usuario.getNome());
        habilitarJanela(true);
    }

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limparTela();
        habilitarJanela(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        carregarUsuario(getUsuarioLogica().getUsuario());
}//GEN-LAST:event_abrirActionPerformed

    public void salvar() {
        UsuarioLogica logica = new UsuarioLogica();

        Usuario usuario = new Usuario();
        if (!edtIdUsuario.getText().equals("")) {
            usuario.setId(Integer.parseInt(edtIdUsuario.getText()));
        }

        usuario.setNome(edtNomeUsuario.getText());
        logica.salva(usuario);

        limparTela();
        habilitarJanela(false);
    }

    private void habilitarJanela(boolean boo) {
        edtNomeUsuario.setEditable(boo);
    }

    private void limparTela() {
        edtIdUsuario.setText("");
        edtNomeUsuario.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new fUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton abrir;
    private javax.swing.JToggleButton btnNovo;
    private javax.swing.JToggleButton btnPesqUsuario;
    private javax.swing.JToggleButton btnSalvarUsuario;
    private javax.swing.JTextField edtIdUsuario;
    private javax.swing.JTextField edtNomeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the usuarioLogica
     */
    public UsuarioLogica getUsuarioLogica() {
        return usuarioLogica;
    }

    /**
     * @param usuarioLogica the usuarioLogica to set
     */
    public void setUsuarioLogica(UsuarioLogica usuarioLogica) {
        this.usuarioLogica = usuarioLogica;
    }
}
