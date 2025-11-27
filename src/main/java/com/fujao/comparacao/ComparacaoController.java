package com.fujao.comparacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/comparacao")
public class ComparacaoController {

    private final ComparacaoService comparacaoService;

    public ComparacaoController(ComparacaoService comparacaoService) {
        this.comparacaoService = comparacaoService;
    }

    @GetMapping("/similares")
    public ResponseEntity<List<ComparacaoResultadoDTO>> compararAnimaisSimilares() {
      
        List<ComparacaoResultadoDTO> resultados = comparacaoService.compararAnimais();
        
        if (resultados.isEmpty()) {
          
            return ResponseEntity.noContent().build(); 
        }
        
      
        return ResponseEntity.ok(resultados); 
    }
}