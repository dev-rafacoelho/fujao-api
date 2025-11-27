package com.fujao.comparacao;

import com.fujao.animais.Animais;
import com.fujao.animais.AnimaisRepository;
import com.fujao.animais_encontrados.AnimalEncontrado;
import com.fujao.animais_encontrados.AnimalEncontradoRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComparacaoService {

    private final AnimaisRepository animaisPerdidosRepository;
    private final AnimalEncontradoRepository animaisEncontradosRepository;

    public ComparacaoService(
            AnimaisRepository animaisPerdidosRepository,
            AnimalEncontradoRepository animaisEncontradosRepository) {
        this.animaisPerdidosRepository = animaisPerdidosRepository;
        this.animaisEncontradosRepository = animaisEncontradosRepository;
    }

    public List<ComparacaoResultadoDTO> compararAnimais() {

        List<Animais> animaisPerdidos = animaisPerdidosRepository.findByPerdido(true);
        
        
        List<ComparacaoResultadoDTO> resultados = new ArrayList<>();

       
        for (Animais perdido : animaisPerdidos) {
            

            String especie = perdido.getEspecie();
            String raca = perdido.getRaca();
            
            if (especie != null && raca != null) {
                
             
                List<AnimalEncontrado> encontradosSimilares = animaisEncontradosRepository
                    .findByEspecieAndRaca(especie, raca);
                
                if (!encontradosSimilares.isEmpty()) {
                    ComparacaoResultadoDTO resultado = new ComparacaoResultadoDTO(
                        perdido.getUsuario_id(), 
                        perdido.getNome(),
                        encontradosSimilares
                    );
                    
                    resultados.add(resultado);
                }
            }
        }

        // 6. Retorna todos os agrupamentos de matches
        return resultados;
    }
}