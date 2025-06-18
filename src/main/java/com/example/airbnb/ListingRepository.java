package com.example.airbnb;
import com.example.airbnb.Models.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;



import java.util.List;

public interface ListingRepository extends MongoRepository<Listing, String> {
    
    List<Listing> findByNameContainingIgnoreCase(String name);
   

}