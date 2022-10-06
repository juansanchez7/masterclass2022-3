package co.usa.reto3.Reto3.repository;

import co.usa.reto3.Reto3.entities.Machine;
import co.usa.reto3.Reto3.repository.crudRepository.MachineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public class MachineRepository {

    @Autowired
    private MachineCrudRepository machineCrudRepository;

    public List<Machine> getAll(){
        return (List<Machine>)machineCrudRepository.findAll();
    }

    public Optional<Machine>getMachine(int id){
        return machineCrudRepository.findById(id);
    }

    public Machine save(Machine g){
        return machineCrudRepository.save(g);
    }

    public void delete(Machine g){machineCrudRepository.delete(g);
    }
}