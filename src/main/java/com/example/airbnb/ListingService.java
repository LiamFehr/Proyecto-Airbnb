package com.example.airbnb;
import com.example.airbnb.ListingRepository;
import com.example.airbnb.Models.Listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    @Autowired
    private ListingRepository repository;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Cacheable("listings")
    public List<Listing> getAll() {
        return repository.findAll();
    }

    public Optional<Listing> getById(String id) {
        return repository.findById(id);
    }

    public Listing save(Listing listing) {
        if (listing.getName() != null) {
            redisTemplate.delete("airbnb:name:" + listing.getName().toLowerCase());
        }
        return repository.save(listing);
    }

    public void delete(String id) {
        repository.findById(id).ifPresent(listing -> {
            if (listing.getName() != null) {
                redisTemplate.delete("airbnb:name:" + listing.getName().toLowerCase());
            }
        });
        repository.deleteById(id);
    }


    
    public Listing findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Listing> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
    public List<Listing> getByNameWithCache(String name) {
        String redisKey = "airbnb:name:" + name.toLowerCase();

        // Buscar en Redis
        List<Listing> cache = (List<Listing>) redisTemplate.opsForValue().get(redisKey);
        if (cache != null) {
            System.out.println("✅ Resultado desde Redis para: " + name);
            return cache;
        }

        // Buscar en MongoDB
        List<Listing> results = repository.findByNameContainingIgnoreCase(name);

        // Guardar en Redis (TTL de 1 hora)
        redisTemplate.opsForValue().set(redisKey, results, Duration.ofSeconds(3600));
        System.out.println("📦 Resultado desde MongoDB y cacheado: " + name);

        return results;
    }

}

