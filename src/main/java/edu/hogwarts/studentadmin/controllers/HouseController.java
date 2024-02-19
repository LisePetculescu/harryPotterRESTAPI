package edu.hogwarts.studentadmin.controllers;

import edu.hogwarts.studentadmin.models.House;
import edu.hogwarts.studentadmin.repositories.HouseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HouseController {

    private HouseRepository houseRepository;

    public HouseController(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @GetMapping("/houses")
    public List<House> allHouses() {
        return houseRepository.findAll();
    }

    @GetMapping("/houses/{id}")
    public ResponseEntity<House> getOneHouse(@PathVariable int id) {
        return ResponseEntity.of(houseRepository.findById(id));
    }

    @PostMapping("/houses")
    @ResponseStatus(HttpStatus.CREATED)
    public House createHouse(@RequestBody House house) {
        return houseRepository.save(house);
    }

    @PutMapping("/houses/{name}")
    public House updateHouse(@PathVariable String name, @RequestBody House house) {
        house.setName(name);
        return houseRepository.save(house);
    }

//    @DeleteMapping("/houses/{id}")
//    public ResponseEntity<House> deleteHouse(@PathVariable String name) {
//        Optional<House> deleteHouse = houseRepository.findById(name);
//        houseRepository.deleteById(id);
//        return ResponseEntity.of(deleteHouse);
//    }


}
