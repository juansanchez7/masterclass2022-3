package co.usa.reto3.Reto3.controller;

import co.usa.reto3.Reto3.entities.Machine;
import co.usa.reto3.Reto3.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Machine")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/all")
    public List<Machine> getAll() {
        return machineService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine g) {
        return machineService.save(g);
    }
}