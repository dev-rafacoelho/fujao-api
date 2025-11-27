package com.fujao.email;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RotinaAgendadaService {

    private final EmailService emailService; 

    public RotinaAgendadaService(EmailService emailService) {
        this.emailService = emailService;
    }


    @Scheduled(fixedRate = 2000000)
    public void dispararEmailPeriodicamente() {
        System.out.println("--- Iniciando a rotina de envio de e-mail (a cada 5 segundos) ---");


        emailService.enviarEmailAssincrono(
            "coelho180305@gmail.com",
            "Email a cada 5s",
            "Este é um e-mail de teste enviado a cada 5 segundos pela rotina agendada."
        );
        
        System.out.println("--- E-mail assíncrono disparado. ---");
    }
}