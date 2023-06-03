package devandroid.anacm.anotacoess.model;

public class Anotacao {
    private String titulo;
    private String anotacao;

    public Anotacao() {}

    public Anotacao(String titulo, String anotacao) {
        this.titulo = titulo;
        this.anotacao = anotacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    @Override
    public String toString() {
        return "Anotacao{" +
                "titulo='" + titulo + '\'' +
                ", anotacao='" + anotacao + '\'' +
                '}';
    }
}
