package SistemaEleitoral;

import java.util.Objects;

public class Eleitor {

    private String nome;
    private String titulo;

    public Eleitor(String nome, String titulo) {
        this.nome = nome;
        this.titulo = titulo;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eleitor eleitor = (Eleitor) o;
        return Objects.equals(titulo, eleitor.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
