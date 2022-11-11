package test;

import SistemaEleitoral.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


class SistemaEleitoralMapTest {

    SistemaEleitoralMap sistema = new SistemaEleitoralMap();


    @Test
    public void testSetCandidate() {
        boolean cadastrouCandidato = sistema.cadastraCandidato("x", 56, Partido.PARTIDO1);
        assertTrue(cadastrouCandidato);
    }

    @Test
    public void testSetVoter() {
        boolean cadastrouEleitorA = sistema.cadastraEleitor("Iranildo", "058.232.215-1");
        assertTrue(cadastrouEleitorA);
        boolean cadastrouEleitorB = sistema.cadastraEleitor("Iranildo", "058.232.215-1");
        assertFalse(cadastrouEleitorB);
    }
    
    @Test
    public void testVote() throws TituloInexistenteException {
        boolean cadastroCandidato = sistema.cadastraCandidato("x", 56, Partido.PARTIDO1);
        boolean cadastroEleitor = sistema.cadastraEleitor("Iranildo", "058.232.215-1");
        try {
            sistema.votar("058.232.215-1", 56);
        } catch (TituloInexistenteException e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    public void testCountVote() throws TituloInexistenteException{
        boolean cadastroCandidato = sistema.cadastraCandidato("X", 56, Partido.PARTIDO1);
        boolean cadastroEleitor = sistema.cadastraEleitor("Iranildo", "058.232.215-1");
        try {
            sistema.votar("058.232.215-1", 56);
            int contadorVotos = sistema.contarVotosParaCandidato(56);
            assertTrue(contadorVotos == 1);
        }catch (TituloInexistenteException e){
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    public void testGetCandidateData() throws CandidatoInexistenteException {
        boolean cadastraCandidato = sistema.cadastraCandidato("x", 56, Partido.PARTIDO1);
        
        try {
            Candidato candidato = sistema.obterDadosDoCandidato("x");
            assertEquals("x", candidato.getNome());
        } catch (CandidatoInexistenteException e) {
            fail("Não deveria lançar exceção");
        }
    }
}

