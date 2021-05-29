package com.project.bootcamp.controller;

import com.project.bootcamp.model.DTO.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<StockDTO> save(@RequestBody StockDTO dto){
            return ResponseEntity.ok(dto);
}
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<StockDTO> update (@RequestBody StockDTO dto){
            return ResponseEntity.ok(dto);
}
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<StockDTO>> findAll() {
        List<StockDTO> list = new ArrayList<>();
        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("Jonin");
        dto.setPrice(1000.0);
        dto.setVariation(100.0);
        dto.setDate(LocalDate.now());
        list.add(dto);

        return ResponseEntity.ok(list);
        }

        @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity<StockDTO> findById(@PathVariable Long id){
            List <StockDTO> list = new ArrayList<>();
            StockDTO stck1 = new StockDTO();
            stck1.setId(1L);
            stck1.setName("Jonin");
            stck1.setPrice(1000.0);
            stck1.setVariation(100.0);
            stck1.setDate(LocalDate.now());
            list.add(stck1);

            StockDTO stck2 = new StockDTO();
            stck2.setId(2L);
            stck2.setName("Genin");
            stck2.setPrice(2000D);
            stck2.setVariation(200D);
            stck2.setDate(LocalDate.now());
            list.add(stck2);

            StockDTO compare = list.stream().
                    filter(x -> x.getId().compareTo(id) ==0).
                    findFirst().get();

            return ResponseEntity.ok(compare);
        }


}
