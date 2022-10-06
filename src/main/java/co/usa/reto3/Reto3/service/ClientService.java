package co.usa.reto3.Reto3.service;

import co.usa.reto3.Reto3.entities.Client;
import co.usa.reto3.Reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client g) {
        if (g.getIdClient() == null) {
            return clientRepository.save(g);
        } else {
            Optional<Client> gaux = clientRepository.getClient(g.getIdClient());
            if (gaux.isPresent()) {
                return g;
            } else {
                return clientRepository.save(g);
            }
        }

    }

    public Client update(Client g) {
        if (g.getIdClient() != null) {
            Optional<Client> q = clientRepository.getClient(g.getIdClient());
            if (q.isPresent()) {
                if (g.getName() != null) {
                    q.get().setName(g.getName());
                }
                if (g.getAge() != null) {
                    q.get().setAge(g.getAge());
                }
                if (g.getPassword() != null) {
                    q.get().setPassword(g.getPassword());
                }
                if (g.getEmail() != null) {
                    q.get().setEmail(g.getEmail());
                }
                clientRepository.save(q.get());
                return q.get();
            } else {
                return g;
            }
        } else {
            return g;
        }
    }

    public boolean delete ( int id){
        boolean flag = false;
        Optional<Client> g = clientRepository.getClient(id);
        if (g.isPresent()) {
            clientRepository.delete(g.get());
            flag = true;
        }
        return flag;
    }


}

