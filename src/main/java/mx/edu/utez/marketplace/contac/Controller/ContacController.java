package mx.edu.utez.marketplace.contac.Controller;

import mx.edu.utez.marketplace.utils.EmailService;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacto")
@CrossOrigin(origins = {"*"})
public class ContacController {
    @Autowired
    EmailService emailService;

    @PostMapping("/")
    public ResponseEntity<Message>sendMailContact(@RequestBody EmailDTO emailDTO, BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity<>(new Message("Verifique los datos", true, null), HttpStatus.BAD_REQUEST);
        }
        if (emailService.sendEmail(emailDTO)){
            return new ResponseEntity<>(new Message("Correo Enviado Correctamente",false, emailDTO), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Error al Enviar el Correo", true, emailDTO), HttpStatus.BAD_REQUEST);
        }
    }
}
