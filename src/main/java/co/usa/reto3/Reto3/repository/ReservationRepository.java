package co.usa.reto3.Reto3.repository;

import co.usa.reto3.Reto3.entities.Reservation;
import co.usa.reto3.Reto3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation g){
        return reservationCrudRepository.save(g);
    }

    public void delete(Reservation g){
        reservationCrudRepository.delete(g);
    }
}