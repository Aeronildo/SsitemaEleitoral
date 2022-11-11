package SistemaEleitoral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SistemaEleitoralMap implements SistemaEleitoralInterface {
    private Map<String, Eleitor> eleitores;
    private Map<String, Candidato> candidatos;
    private List<Voto> votos;

    public SistemaEleitoralMap() {
        this.eleitores = new HashMap<>();
        this.candidatos  = new HashMap<>();
        this.votos = new ArrayList<>();
    }

    @Override
    public Candidato obterDadosDoCandidato(String nome) throws CandidatoInexistenteException {
        Candidato candidato = this.candidatos.get(nome);
        if (candidato == null) {
            throw new CandidatoInexistenteException("Não existe candidato com o nome "+nome);
        } else {
            return candidato;
        }
    }

    public void votar (String numTitulo, int numVotado) throws TituloInexistenteException {
        if (eleitores.containsKey(numTitulo)){
            this.votos.add(new Voto(numVotado));
        }else{
            throw new TituloInexistenteException("titulo"+numTitulo+ "não encontrado");
        }
    }

    public int contarVotosParaCandidato(int numero){
        int quant = 0;
        for (Voto v: this.votos){
            if (v.getNumVotado() == numero){
                quant++;
            }
        }
        return quant;
    }

    @Override
    public boolean cadastraCandidato(String nome, int numero, Partido partido) {
        if (this.candidatos.containsKey(nome)){
            return false;
        }else{
            Candidato candidato = new Candidato(nome, numero, partido);
            this.candidatos.put(nome, candidato);
        }
        return true;
    }

    @Override
    public boolean cadastraEleitor(String nome, String titulo) {
        if (this.eleitores.containsKey(titulo)){
            return false;
        }else{
            Eleitor eleitor = new Eleitor(nome, titulo);
            this.eleitores.put(titulo, eleitor);
            return true;
        }
    }
}
