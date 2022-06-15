package nl.novi.backend.spring.techiteasyhomework.controllers;

import nl.novi.backend.spring.techiteasyhomework.Dtos.TelevisionDto;
import nl.novi.backend.spring.techiteasyhomework.Dtos.WallBracketDto;
import nl.novi.backend.spring.techiteasyhomework.services.TelevisionWallBracketService;
import nl.novi.backend.spring.techiteasyhomework.services.WallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class WallBracketController {
    private final WallBracketService wallBracketService;
    private final TelevisionWallBracketService televisionWallBracketService;

    @Autowired
    public WallBracketController(WallBracketService wallBracketService,
                                 TelevisionWallBracketService televisionWallBracketService) {
        this.wallBracketService = wallBracketService;
        this.televisionWallBracketService = televisionWallBracketService;
    }

    @GetMapping("/wallbrackets")
    public List<WallBracketDto> getAllWallBrackets() {

        List<WallBracketDto> wallBrackets = wallBracketService.getAllWallBrackets();

        return wallBrackets;
    }

    @GetMapping("/wallbrackets/{id}")
    public WallBracketDto getWallBracket(@PathVariable("id") Long id) {

        WallBracketDto wallBracketDto = wallBracketService.getWallBracket(id);

        return wallBracketDto;
    }

    @PostMapping("/wallbrackets")
    public WallBracketDto addWallBracket(@RequestBody WallBracketDto dto) {
        WallBracketDto wallBracket = wallBracketService.addWallbracket(dto);
        return wallBracket;
    }

    @DeleteMapping("/wallbrackets/{id}")
    public void deleteWallBracket(@PathVariable("id") Long id) {
        wallBracketService.deleteWallBracket(id);
    }

    @PutMapping("/wallbrackets/{id}")
    public WallBracketDto updateWallBracket(@PathVariable("id") Long id, @RequestBody WallBracketDto dto) {
        wallBracketService.updateWallBracket(id, dto);
        return dto;
    }

    @GetMapping("/wallbrackets/televisions/{wallBracketId}")
    public Collection<TelevisionDto> getTelevisionsByWallBracketId(@PathVariable("wallBracketId") Long wallBracketId){
        return televisionWallBracketService.getTelevisionWallBracketsByWallBracketId(wallBracketId);
    }
}