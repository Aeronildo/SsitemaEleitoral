package SistemaEleitoral;

/**
 * Interface that represents the main operations of a electoral system
 */
public interface SistemaEleitoralInterface {

    /**
     * add votes for a candidate
     * @param numTitulo voter's id number
     * @param numeroVotado voted candidate's number
     * @throws TituloInexistenteException when there is no voter's id number in the system
     */
    public void votar(String numTitulo, int numeroVotado) throws TituloInexistenteException;

    /**
     * get all the candidate data
     * @param nome candidate's name
     * @return an object candidate with all its data
     * @throws CandidatoInexistenteException when there is no candidate's name
     */
    public Candidato obterDadosDoCandidato(String nome) throws CandidatoInexistenteException;

    /**
     * Counts how many votes a candidate received
     * @param numero candidate's voting number
     * @return candidate's number of votes
     */
    public int contarVotosParaCandidato(int numero);

    /**
     * Register a candidate in the system
     * @param nome candidate's name
     * @param numero candidate's voting number
     * @param partido candidate's party
     * @return false if candidate's name is already registered, else true
     */
    public boolean cadastraCandidato(String nome, int numero, Partido partido);

    /**
     * Register a voter in the system
     * @param nome Voter's name
     * @param titulo Voter's id number
     * @return false if voter's name is already registered, else true
     */
    public boolean cadastraEleitor(String nome, String titulo);
}
