package likelion_backend.OnSiL.domain.map.controller;

import io.swagger.v3.oas.annotations.Operation;
import likelion_backend.OnSiL.domain.map.dto.LocationDto;
import likelion_backend.OnSiL.domain.map.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")

public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    @Operation(summary = "산책 코스 전체 조회 //민석")
    public List<LocationDto> getAllLocations() {
        return locationService.findALl();
    }

    @GetMapping("/{id}")
    @Operation(summary = "산책 코스 조회 //민석")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable Long id) {
        Optional<LocationDto> locationDto = locationService.findById(id);
        if (locationDto.isPresent()) {
            return ResponseEntity.ok(locationDto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "산책 코스 등록 //민석")
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto) {
        LocationDto savedLocation = locationService.save(locationDto);
        return ResponseEntity.ok(savedLocation);
    }

    @PutMapping("/{id}")
    @Operation(summary = "산책 코스 수정 //민석")
    public ResponseEntity<LocationDto> updateLocation(@PathVariable Long id, @RequestBody LocationDto locationDto) {
        Optional<LocationDto> locationOptional = locationService.findById(id);
        if (locationOptional.isPresent()) {
            LocationDto updatedLocation = locationService.save(locationDto);
            return ResponseEntity.ok(updatedLocation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "산책 코스 삭제 //민석")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        if (locationService.findById(id).isPresent()) {
            locationService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}