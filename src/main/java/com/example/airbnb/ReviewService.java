package com.example.airbnb;
import com.example.airbnb.Models.Review;
import com.example.airbnb.view.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    public List<Review> findByListingId(String listingId) {
        return repository.findByListingId(listingId);
    }

    public Review save(Review review) {
        return repository.save(review);
    }


    
    public void deleteById(String id) {
        repository.deleteById(id); // ✅ CORRECTO
    }
}