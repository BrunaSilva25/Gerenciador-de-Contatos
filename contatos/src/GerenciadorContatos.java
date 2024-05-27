import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GerenciadorContatos {
    private List<Contato> contatos;

    public GerenciadorContatos() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public boolean excluirContato(String nome, String sobrenome) {
        Iterator<Contato> iterator = contatos.iterator();
        while (iterator.hasNext()) {
            Contato contato = iterator.next();
            if (contato.getNome().equals(nome) && contato.getSobrenome().equals(sobrenome)) {
                iterator.remove();
                return true; // Contato encontrado e excluído
            }
        }
        return false; // Contato não encontrado
    }

    public Contato buscarContato(String nome, String sobrenome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome) && contato.getSobrenome().equals(sobrenome)) {
                return contato;
            }
        }
        return null;
    }
}