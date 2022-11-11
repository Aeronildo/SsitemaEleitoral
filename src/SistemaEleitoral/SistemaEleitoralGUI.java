package SistemaEleitoral;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.*;

public class SistemaEleitoralGUI extends JFrame implements ActionListener {

    JButton votebutton = new JButton("Votar");
    JButton getDatabutton = new JButton("Obter Dados do Candidato");
    JButton countVotebutton = new JButton("Contar Votos do Candidato");
    JButton registerCandidatebutton = new JButton("Cadastrar Candidato");
    JButton registerVoterbutton = new JButton("Cadastrar Eleitor");
    ImageIcon Image = new ImageIcon("./imgs/tre.jpg");
    JLabel label = new JLabel(Image);
    JLabel text = new JLabel("Sistema Eleitoral");
    Font font = new Font("arial", Font.BOLD, 22);

    public SistemaEleitoralGUI() {

        add(label);

        //main window config
        setTitle("programa Sistema Eleitoral");
        setSize(500, 375);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         //Buttons
        votebutton.setBounds(150, 200, 200, 30);
        add(votebutton);
        votebutton.addActionListener(this);
        getDatabutton.setBounds(150, 150, 200, 30);
        add(getDatabutton);
        getDatabutton.addActionListener(this);
        countVotebutton.setBounds(150, 250, 200, 30);
        add(countVotebutton);
        countVotebutton.addActionListener(this);
        registerCandidatebutton.setBounds(150, 50, 200, 30);
        add(registerCandidatebutton);
        registerCandidatebutton.addActionListener(this);
        registerVoterbutton.setBounds(150, 100, 200, 30);
        add(registerVoterbutton);
        registerVoterbutton.addActionListener(this);
        //text configs
        text.setBounds(150, 0, 350, 20);
        text.setFont(font);
        add(text);
        add(label);

    }


    public static void main(String[] args) {
        new SistemaEleitoralGUI();


    }

    SistemaEleitoralMap sistema = new SistemaEleitoralMap();

    @Override
    public void actionPerformed(ActionEvent e){

        if (e.getSource() == (votebutton)) {
            String voterID = JOptionPane.showInputDialog("Digite O titulo: ");
            int voteNumber = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Candidato: "));
            try {
                sistema.votar(voterID, voteNumber);
                JOptionPane.showMessageDialog(null,"CONFIRMADO");
            } catch (TituloInexistenteException b) {
                JOptionPane.showMessageDialog(null, "Titulo inexistente, tente novamente");
            }

        }


        if (e.getSource() == (getDatabutton)) {
            String candidate = JOptionPane.showInputDialog("Digite o nome do candidato: ");
            try {
                Candidato getData = sistema.obterDadosDoCandidato(candidate);
                JOptionPane.showMessageDialog(null, getData);
                JOptionPane.showMessageDialog(null,"sucesso");

            } catch (CandidatoInexistenteException c) {
                JOptionPane.showMessageDialog(null, "Candidato inexistente");
            }
        }


        if(e.getSource() == countVotebutton){
            int countVote = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do candidato: "));
            int votes = sistema.contarVotosParaCandidato(countVote);
            if(votes == 0){
                JOptionPane.showMessageDialog(null, "Não há votos para o candidato.");
            } else{
                JOptionPane.showMessageDialog(null, votes);
            }

        }


        if(e.getSource() == registerCandidatebutton){
            String candidateName = JOptionPane.showInputDialog("Digite o nome do Candidato. \n Nome:");
            int x = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do Candidato: ")); //Candidate's number
            String y = JOptionPane.showInputDialog("PARTIDO1 \n PARTIDO2 \n PARTIDO3 \n Escolha o partido: " ); //parties
            Partido partido = null;
            if(y.equals("PARTIDO1")){
                partido = Partido.PARTIDO1;
            } else if(y.equals("PARTIDO2")){
                partido = Partido.PARTIDO2;
            } else if(y.equals("PARTIDO3")){
                partido = Partido.PARTIDO3;
            }
            if(candidateName.equals("") || x == 0 || y.equals("")){
                JOptionPane.showMessageDialog(null, "Inválido.");
            } else {
                sistema.cadastraCandidato(candidateName, x, partido);
            }


        }

         //registers a voter passing his name and id
        if(e.getSource() == registerVoterbutton){
            String name = JOptionPane.showInputDialog("Digite o nome do eleitor: ");
            String id = JOptionPane.showInputDialog("Digite o titulo do eleitor: ");
            if(name.equals("") || id.equals("")){
                JOptionPane.showMessageDialog(null, "Inválido");
            }else {
                sistema.cadastraEleitor(name, id);
            }
        }


    }

}
