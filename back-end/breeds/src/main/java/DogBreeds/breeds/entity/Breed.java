package DogBreeds.breeds.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="breeds")
public class Breed {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private String imageUrl;
    @Max(5)
    private int trainability;
    @Min(1)
    @Max(30)
    private int minLifeSpan;
    @Min(1)
    @Max(30)
    private int maxLifeSpan;
    @Enumerated(EnumType.STRING)
    @Column(name="size")
    private Size size;

    public Breed() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getTrainability() {
        return trainability;
    }

    public void setTrainability(int trainability) {
        this.trainability = trainability;
    }

    public int getMinLifeSpan() {
        return minLifeSpan;
    }

    public void setMinLifeSpan(int minLifeSpan) {
        this.minLifeSpan = minLifeSpan;
    }

    public int getMaxLifeSpan() {
        return maxLifeSpan;
    }

    public void setMaxLifeSpan(int maxLifeSpan) {
        this.maxLifeSpan = maxLifeSpan;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", trainability=" + trainability +
                ", minLifeSpan=" + minLifeSpan +
                ", maxLifeSpan=" + maxLifeSpan +
                ", size=" + size +
                '}';
    }
}


