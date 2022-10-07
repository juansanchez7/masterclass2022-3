package co.usa.reto3.Reto3.service;

import co.usa.reto3.Reto3.entities.Reservation;
import co.usa.reto3.Reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> (int id) {
        return reservationRepository.getReservation(id);
    }

    public Product save(Product g) {
        if (g.getId() == null) {
            return reservationRepository.save(g);
        } else {
            Optional<Product> gaux = reservationRepository.getProduct(g.getId());
            if (gaux.isPresent()) {
                return g;
            } else {
                return reservationRepository.save(g);
            }
        }

    }

    public Product update(Product g) {
        if (g.getId() != null) {
            Optional<Product> q = reservationRepository.getProduct(g.getId());
            if (q.isPresent()) {
                if (g.getName() != null) {
                    q.get().setName(g.getName());
                }
                if (g.getYear() != null) {
                    q.get().setYear(g.getYear());
                }
                reservationRepository.save(q.get());
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
            Optional<Product> g = reservationRepository.getProduct(id);
            if (g.isPresent()) {
                reservationRepository.delete(g.get());
                flag = true;
            }
            return flag;
        }


}

