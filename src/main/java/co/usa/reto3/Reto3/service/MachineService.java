package co.usa.reto3.Reto3.service;

import co.usa.reto3.Reto3.entities.Machine;
import co.usa.reto3.Reto3.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll() {
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(int id) {
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine g) {
        if (g.getId() == null) {
            return machineRepository.save(g);
        } else {
            Optional<Machine> gaux = machineRepository.getMachine(g.getId());
            if (gaux.isPresent()) {
                return g;
            } else {
                return machineRepository.save(g);
            }
        }

    }

    public Machine update(Machine g) {
        if (g.getId() != null) {
            Optional<Machine> q = machineRepository.getMachine(g.getId());
            if (q.isPresent()) {
                if (g.getName() != null) {
                    q.get().setName(g.getName());
                }
                if (g.getBrand() != null) {
                    q.get().setBrand(g.getBrand());
                }
                if (g.getYear() != null) {
                    q.get().setYear(g.getYear());
                }
                if (g.getDescription() != null) {
                    q.get().setDescription(g.getDescription());
                }
                if (g.getCategory() != null) {
                    q.get().setCategory(g.getCategory());
                }
                machineRepository.save(q.get());
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
            Optional<Machine> g = machineRepository.getMachine(id);
            if (g.isPresent()) {
                machineRepository.delete(g.get());
                flag = true;
            }
            return flag;
        }


}

