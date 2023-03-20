package DogBreeds.breeds.controller;

import DogBreeds.breeds.entity.Breed;
import DogBreeds.breeds.repository.BreedRepository;
import jakarta.validation.Valid;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping ("/api/breeds")
public class BreedController {


    @Autowired
    private BreedRepository breedRepository;

    @GetMapping
    public List<Breed> getAllBreeds(@RequestParam(name="search", required = false) String s){
        if(Strings.isBlank(s)){
            return breedRepository.findAll();
        } else {
            return breedRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(s,s);
        }
    }
    @GetMapping("/{id}")
    public Breed getBreedById(@PathVariable Integer id){
        Optional<Breed> result = breedRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public Breed createBreed(@Valid @RequestBody Breed breed){
        Optional<Breed> result = breedRepository.findById(breed.getId());
        if(result.isPresent()){
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
        } else {
            return breedRepository.save(breed);
        }
    }
    @PutMapping("/{id}")
    public Breed update(@Valid @PathVariable Integer id, @RequestBody Breed breed){
        Optional<Breed> result = breedRepository.findById(id);
        if(result.isPresent()){
            breed.setId(id);
            return breedRepository.save(breed);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteBreedById(@PathVariable Integer id){
        if(breedRepository.existsById(id)){
            breedRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
