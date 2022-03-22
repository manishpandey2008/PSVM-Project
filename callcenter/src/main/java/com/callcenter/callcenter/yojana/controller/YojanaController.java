package com.callcenter.callcenter.yojana.controller;

import com.callcenter.callcenter.common.dto.ResponceDto;
import com.callcenter.callcenter.yojana.dto.YojanaDto;
import com.callcenter.callcenter.yojana.sservice.YojanaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/yojana")
public class YojanaController {
    private final YojanaService yojanaService;

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok().body("Yojana service is working fine");
    }

    @PostMapping("/")
    public ResponseEntity<YojanaDto> addYojana(@RequestBody YojanaDto yojanaDto) {
        log.info("Add new yojana {}",yojanaDto.getYojanaName());
        return ResponseEntity.ok().body(yojanaService.addYojana(yojanaDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<YojanaDto>> getAllYojanas() {
        log.info("Get all yojanas");
        return ResponseEntity.ok().body(yojanaService.getAllYojanas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponceDto> deleteYojana(@PathVariable Long id) {
        log.info("Delete yojana which id is {}",id);
        return ResponseEntity.ok().body(yojanaService.deleteYojana(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<YojanaDto> getYojanaById(@PathVariable Long yojanaId) {
        log.info("Get yojana which id is {}",yojanaId);
        return ResponseEntity.ok().body(yojanaService.getYojanaById(yojanaId));
    }

    @GetMapping("/center/{centerId}")
    public ResponseEntity<List<YojanaDto>> getAllYojanaByCenterId(@PathVariable Long centerId) {
        log.info("Get all yojana by center which center id is {}",centerId);
        return ResponseEntity.ok().body(yojanaService.getAllYojanaByCenterId(centerId));
    }

}
