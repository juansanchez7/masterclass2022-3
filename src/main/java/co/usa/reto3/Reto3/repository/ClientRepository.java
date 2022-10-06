package co.usa.reto3.Reto3.repository;

import co.usa.reto3.Reto3.entities.Client;
import co.usa.reto3.Reto3.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>)clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client g){
        return clientCrudRepository.save(g);
    }

    public void delete(Client g){clientCrudRepository.delete(g);
    }
}