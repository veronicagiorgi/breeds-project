package DogBreeds.breeds.repository;

import DogBreeds.breeds.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedRepository extends JpaRepository <Breed, Integer> {

    List<Breed> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String breed, String breed2);



}
