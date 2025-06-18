package com.example.airbnb;
import com.example.airbnb.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ListingRepository extends MongoRepository<Listing, String> {
    List<Listing> findByNeighborhood(String neighborhood);
    List<Listing> findByNameContainingIgnoreCase(String name);
}