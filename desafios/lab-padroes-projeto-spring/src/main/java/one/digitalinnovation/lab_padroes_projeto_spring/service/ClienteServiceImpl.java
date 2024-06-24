package one.digitalinnovation.lab_padroes_projeto_spring.service;

import jakarta.persistence.EntityNotFoundException;
import one.digitalinnovation.lab_padroes_projeto_spring.model.Cliente;
import one.digitalinnovation.lab_padroes_projeto_spring.model.Endereco;
import one.digitalinnovation.lab_padroes_projeto_spring.repository.ClienteRepository;
import one.digitalinnovation.lab_padroes_projeto_spring.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private ClienteRepository clienteRepository;
    private EnderecoRepository enderecoRepository;
    private ViaCepService viaCepService;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              EnderecoRepository enderecoRepository,
                              ViaCepService viaCepService) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new EntityNotFoundException("Cliente com id " + id + " não foi encontrado"));
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            salvarClienteComCep(cliente);
        } else {
            throw new EntityNotFoundException("Cliente com id " + id + " não foi encontrado");
        }
    }

    @Override
    public void deletar(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Cliente com id " + id + " não foi encontrado");
        }
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}

