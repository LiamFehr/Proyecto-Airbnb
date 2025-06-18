package com.example.airbnb;
import com.example.airbnb.Listing;
import com.example.airbnb.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    @Autowired
    private ListingRepository repository;

    @Cacheable("listings")
    public List<Listing> getAll() {
        return repository.findAll();
    }

    public Optional<Listing> getById(String id) {
        return repository.findById(id);
    }

    public Listing save(Listing listing) {
        return repository.save(listing);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Listing> searchByNeighborhood(String neighborhood) {
        return repository.findByNeighborhood(neighborhood);
    }

    public List<Listing> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}

